package com.github.azurapi.azurapikotlin.json

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import com.github.azurapi.azurapikotlin.utils.ShipParser
import org.json.JSONObject

/**
 * JSON deserializer object
 * @throws DatabaseException
 */
class Takao {

    private lateinit var jsonDatabase: JSONObject
    var shipsById = HashMap<String, Ship>()
    var shipsByName = HashMap<String, Ship>()

    init {
        loadDatabase()
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

    private fun loadDatabase() {
        try {
            jsonDatabase = loadJSON()
            for (shipId in jsonDatabase.keySet()) {
                val ship = ShipParser.jsonToShip(jsonDatabase.getJSONObject(shipId), shipId)
                shipsById[ship.id.toLowerCase()] = ship
                shipsByName[ship.names.en.toLowerCase()] = ship
            }
        } catch (e: Exception) {
            throw DatabaseException("Could not reload database: (${e.message})")
        }
    }
}