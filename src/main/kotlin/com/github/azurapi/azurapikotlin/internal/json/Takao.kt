package com.github.azurapi.azurapikotlin.internal.json

import com.github.azurapi.azurapikotlin.internal.entities.Equipment
import com.github.azurapi.azurapikotlin.internal.entities.Lang
import com.github.azurapi.azurapikotlin.internal.entities.RemoteVersion
import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import com.github.azurapi.azurapikotlin.internal.utils.info.TakaoInfo
import com.github.azurapi.azurapikotlin.internal.utils.parser.jsonToEquipment
import com.github.azurapi.azurapikotlin.internal.utils.parser.jsonToShip
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import info.debatty.java.stringsimilarity.Cosine
import java.util.Date
import org.json.JSONObject

/**
 * JSON deserializer object.
 * THIS CLASS IS NOT MEANT TO BE USED, USE ATAGO INSTEAD.
 * @throws DatabaseException
 */
internal class Takao {

    private lateinit var jsonShipDatabase: JSONObject
    private lateinit var jsonEquipmentDatabase: JSONObject

    lateinit var lastCheckDate: Date
    var remoteJsonVersion = HashMap<String, RemoteVersion>()

    val shipsById = HashMap<String, Ship>()
    val shipsByEnName = HashMap<String, Ship>()
    val shipsByJpName = HashMap<String, Ship>()
    val shipsByKrName = HashMap<String, Ship>()
    val shipsByCnName = HashMap<String, Ship>()

    val equipmentsByEnName = HashMap<String, Equipment>()
    val equipmentsByJpName = HashMap<String, Equipment>()
    val equipmentsByKrName = HashMap<String, Equipment>()
    val equipmentsByCnName = HashMap<String, Equipment>()

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
        try {
            // Update ships
            if (remoteJsonVersion["ships"]?.versionNumber ?: 0 < (version["ships"]
                    ?: error("ships version not found")).versionNumber
            ) {
                remoteJsonVersion["ships"] = version["ships"] ?: error("ships version not found")
                jsonShipDatabase = loadJSON(TakaoInfo.JSON_SHIP)
                for (shipId in jsonShipDatabase.keySet()) {
                    val ship = jsonToShip(jsonShipDatabase.getJSONObject(shipId), shipId)
                    shipsById[ship.id] = ship
                    shipsByEnName[ship.names.en] = ship
                    shipsByCnName[if (ship.names.cn.isNotEmpty()) ship.names.cn else ship.names.en] = ship
                    shipsByJpName[if (ship.names.jp.isNotEmpty()) ship.names.jp else ship.names.en] = ship
                    shipsByKrName[if (ship.names.kr.isNotEmpty()) ship.names.kr else ship.names.en] = ship
                }
            }
        } catch (e: Exception) {
            throw DatabaseException("Could not reload ships database: (${e.message})")
        }
        try {
            // Update equipments
            if (remoteJsonVersion["equipments"]?.versionNumber ?: 0 < (version["equipments"]
                    ?: error("equipments version not found")).versionNumber
            ) {
                remoteJsonVersion["equipments"] = version["equipments"] ?: error("equipments version not found")
                jsonEquipmentDatabase = loadJSON(TakaoInfo.JSON_EQUIPMENT)
                for (equipmentId in jsonEquipmentDatabase.keySet()) {
                    val equipment = jsonToEquipment(jsonEquipmentDatabase.getJSONObject(equipmentId), equipmentId)
                    equipmentsByEnName[equipment.names.en] = equipment
                    equipmentsByEnName[equipment.names.cn] = equipment
                    equipmentsByEnName[equipment.names.jp] = equipment
                    equipmentsByEnName[equipment.names.kr] = equipment
                }
            }
        } catch (e: Exception) {
            throw DatabaseException("Could not reload equipements database: (${e.message})")
        }
    }

    /**
     * Get version of the remote json
     */
    private fun getRemoteDatabaseVersion(): Map<String, RemoteVersion> {
        val remoteVersion = HashMap<String, RemoteVersion>()
        try {
            val jsonVersion = loadJSON(TakaoInfo.JSON_VERSION)
            for (entity in jsonVersion.keys()) {
                remoteVersion[entity] = RemoteVersion(
                    jsonVersion.getJSONObject(entity).getInt("version-number"),
                    Date(jsonVersion.getJSONObject(entity).getLong("last-data-refresh-date"))
                )
            }
            return remoteVersion
        } catch (e: Exception) {
            throw DatabaseException("Could not retrieve database version: (${e.message})")
        }
    }

    /**
     * Returns the closest string from ``stringSet`` of ``search``
     * @param stringSet set of strings to look at
     * @param search string query
     * @param ignoreCase ignore case, true by default
     */
    private fun closestString(stringSet: Set<String>, search: String, ignoreCase: Boolean = true): String? {
        if (stringSet.isEmpty()) {
            return null
        }
        val cosine = Cosine()
        var bestScore = 0.0
        var result: String = search
        for (s in stringSet) {
            val score = cosine.similarity(
                if (ignoreCase) s.toLowerCase() else s,
                if (ignoreCase) search.toLowerCase() else search
            )
            if (score > bestScore) {
                result = s
                bestScore = score
            }
        }
        return result
    }

    /**
     * Find the closest ship matching `search` terms
     * @param search
     * @param lang
     */
    fun findShip(search: String, lang: Lang): Ship? {
        val shipsByName = when (lang) {
            Lang.EN -> shipsByEnName
            Lang.CN -> shipsByCnName
            Lang.JP -> shipsByJpName
            Lang.KR -> shipsByKrName
            Lang.ANY -> shipsByEnName + shipsByCnName + shipsByJpName + shipsByKrName
        }
        return shipsByName[closestString(shipsByName.keys, search)]
    }

    /**
     * Find the closest equipment matching `search` terms
     * @param search
     * @param lang
     */
    fun findEquipment(search: String, lang: Lang): Equipment? {
        val equipmentsByName = when (lang) {
            Lang.EN -> equipmentsByEnName
            Lang.CN -> equipmentsByCnName
            Lang.JP -> equipmentsByJpName
            Lang.KR -> equipmentsByKrName
            Lang.ANY -> equipmentsByEnName + equipmentsByCnName + equipmentsByJpName + equipmentsByKrName
        }
        return equipmentsByName[closestString(equipmentsByName.keys, search)]
    }
}
