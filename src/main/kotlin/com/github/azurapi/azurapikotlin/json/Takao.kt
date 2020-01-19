package com.github.azurapi.azurapikotlin.json

import com.github.azurapi.azurapikotlin.internal.entities.Lang
import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import com.github.azurapi.azurapikotlin.utils.ShipParser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import info.debatty.java.stringsimilarity.Cosine
import org.json.JSONObject
import java.util.Date

/**
 * JSON deserializer object.
 * THIS CLASS IS NOT MEANT TO BE USED, USE ATAGO INSTEAD.
 * @throws DatabaseException
 */
class Takao {

    private lateinit var jsonDatabase: JSONObject
    private lateinit var jsonVersion: JSONObject

    lateinit var lastCheckDate: Date
    lateinit var lastUpdatedDatabaseDate: Date
    var databaseVersion = 0

    var shipsById = HashMap<String, Ship>()
    var shipsByEnName = HashMap<String, Ship>()
    var shipsByJpName = HashMap<String, Ship>()
    var shipsByKrName = HashMap<String, Ship>()
    var shipsByCnName = HashMap<String, Ship>()

    init {
        loadDatabase()
    }

    private fun loadJSON(url: String): JSONObject {
        val (_, response, result) = url
            .httpGet()
            .responseJson()
        return if (response.statusCode == 200) {
            result.get().obj()
        } else {
            throw DatabaseException("Could not load database: (error ${response.statusCode})")
        }
    }

    /**
     * Load remote json and update local database
     */
    fun loadDatabase() {
        lastCheckDate = Date()
        val version = getRemoteDatabaseVersion()
        // Database is already up to date
        if (databaseVersion >= version.first) {
            return
        }
        databaseVersion = version.first
        lastUpdatedDatabaseDate = version.second
        try {
            jsonDatabase = loadJSON(TakaoInfo.JSON_SOURCE)
            for (shipId in jsonDatabase.keySet()) {
                val ship = ShipParser.jsonToShip(jsonDatabase.getJSONObject(shipId), shipId)
                shipsById[ship.id] = ship
                shipsByEnName[ship.names.en] = ship
                shipsByCnName[if (ship.names.cn.isNotEmpty()) ship.names.cn else ship.names.en] = ship
                shipsByJpName[if (ship.names.jp.isNotEmpty()) ship.names.jp else ship.names.en] = ship
                shipsByKrName[if (ship.names.kr.isNotEmpty()) ship.names.kr else ship.names.en] = ship
            }
        } catch (e: Exception) {
            throw DatabaseException("Could not reload database: (${e.message})")
        }
    }

    /**
     * Get version of the remote json
     */
    private fun getRemoteDatabaseVersion(): Pair<Int, Date> {
        try {
            jsonVersion = loadJSON(TakaoInfo.JSON_VERSION).getJSONObject("ships")
            return Pair(jsonVersion.getInt("version-number"), Date(jsonVersion.getLong("last-data-refresh-date")))
        } catch (e: Exception) {
            throw DatabaseException("Could not retrieve database version: (${e.message})")
        }
    }

    /**
     * Find the closest ship matching `search` terms
     * @param search
     */
    fun findShip(search: String, lang: Lang): Ship? {
        val cosine = Cosine()
        var bestScore = 0.0
        var result: Ship? = null
        val databaseLang = when(lang) {
            Lang.EN -> shipsByEnName
            Lang.CN -> shipsByCnName
            Lang.JP -> shipsByJpName
            Lang.KR -> shipsByKrName
            Lang.ANY -> shipsByEnName + shipsByCnName + shipsByJpName + shipsByKrName
        }
        for ((name, ship) in databaseLang.entries) {
            val score = cosine.similarity(search.toLowerCase(), name.toLowerCase())
            if (score > bestScore) {
                result = ship
                bestScore = score
            }
        }
        return result
    }
}