package com.github.sylux6.azurapikotlin.database

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.sylux6.azurapikotlin.internal.entities.Ship
import com.github.sylux6.azurapikotlin.internal.exceptions.DatabaseException
import com.github.sylux6.azurapikotlin.utils.ShipParser
import org.json.JSONObject

/**
 * JSON deserializer object
 */
object Takao {

    private lateinit var database: JSONObject
    var shipsById = HashMap<String, Ship>()
    var shipsByName = HashMap<String, Ship>()

    init {
        reloadDatabase()
    }

    fun loadJSON(): JSONObject {
        val (_, response, result) = TakaoInfo.JSON_SOURCE
            .httpGet()
            .responseJson()
        return if (response.statusCode == 200) {
            result.get().obj()
        } else {
            throw DatabaseException("Could not load database: (error ${response.statusCode})")
        }
    }

    fun reloadDatabase() {
        try {
            database = loadJSON()
            for (shipId in database.keySet()) {
                val ship = ShipParser.jsonToShip(database.getJSONObject(shipId), shipId)
                shipsById[ship.id] = ship
                shipsByName[ship.names.en] = ship
            }
        } catch (e: Exception) {
            throw DatabaseException("Could not reload database: (${e.message})")
        }
    }
}