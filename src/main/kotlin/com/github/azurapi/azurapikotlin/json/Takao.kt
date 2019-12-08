package com.github.azurapi.azurapikotlin.json

import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import com.github.azurapi.azurapikotlin.utils.ShipParser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import info.debatty.java.stringsimilarity.Cosine
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap

/**
 * JSON deserializer object.
 * THIS CLASS IS NOT MEANT TO BE USED, USE ATAGO INSTEAD.
 * @throws DatabaseException
 */
class Takao {

    private lateinit var jsonDatabase: JSONObject
    private lateinit var jsonVersion: JSONObject

    lateinit var lastUpdated: Date
    lateinit var lastUpdatedDatabase: Date
    lateinit var databaseVersion: String

    var shipsById = HashMap<String, Ship>()
    var shipsByName = HashMap<String, Ship>()

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

    fun loadDatabase() {
        lastUpdated = Date()
        try {
            jsonDatabase = loadJSON(TakaoInfo.JSON_SOURCE)
            jsonVersion = loadJSON(TakaoInfo.JSON_VERSION)
            for (shipId in jsonDatabase.keySet()) {
                val ship = ShipParser.jsonToShip(jsonDatabase.getJSONObject(shipId), shipId)
                shipsById[ship.id.toLowerCase()] = ship
                shipsByName[ship.names.en.toLowerCase()] = ship
            }
            databaseVersion = jsonVersion.getInt("version-number").toString()
            lastUpdatedDatabase = Date(jsonVersion.getLong("last-data-refresh-date"))
        } catch (e: Exception) {
            throw DatabaseException("Could not reload database: (${e.message})")
        }
    }

    /**
     * Find the closest ship matching `search` terms
     * @param search
     */
    fun findShip(search: String): Ship? {
        val cosine = Cosine()
        var bestScore = 0.0
        var result: Ship? = null
        for ((name, ship) in shipsByName.entries) {
            val score = cosine.similarity(search.toLowerCase(), name)
            if (score > bestScore) {
                result = ship
                bestScore = score
            }
        }
        return result
    }
}