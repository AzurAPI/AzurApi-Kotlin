package com.github.azurapi.azurapikotlin.api

import com.github.azurapi.azurapikotlin.internal.entities.Equipment
import com.github.azurapi.azurapikotlin.internal.entities.Lang
import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.entities.Version
import com.github.azurapi.azurapikotlin.internal.exceptions.ApiException
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import com.github.azurapi.azurapikotlin.internal.exceptions.EquipmentNotFoundException
import com.github.azurapi.azurapikotlin.internal.exceptions.ShipNotFoundException
import com.github.azurapi.azurapikotlin.internal.json.Takao
import com.github.azurapi.azurapikotlin.internal.utils.info.AtagoInfo

/**
 * API class
 * @throws ShipNotFoundException
 * @throws DatabaseException
 * @throws ApiException
 */
object Atago {

    private val database = try {
        Takao()
    } catch (e: DatabaseException) {
        throw DatabaseException(e.message ?: "")
    }

    /**
     * @since 1.0.0
     *
     * Get information about a ship by name
     * @param name name of the ship
     * @param lang language, any language by default
     */
    fun getShipByName(name: String, lang: Lang = Lang.ANY): Ship {
        return database.findShip(name, lang) ?: throw ShipNotFoundException("Could not find ship with name: $name")
    }

    /**
     * @since 1.0.0
     *
     * Get information about a ship by id
     * @param id id of the ship
     */
    fun getShipById(id: String, caseSensitive: Boolean = false): Ship {
        val formattedId = if (caseSensitive) id.toLowerCase() else id
        return (if (caseSensitive) database.shipsById.mapKeys { it.key.toLowerCase() } else
            database.shipsById)[formattedId] ?: throw ShipNotFoundException("Could not find ship with id: $id")
    }

    /**
     * @since 1.0.0
     *
     * Get list of all ships
     */
    fun getAllShips(): Sequence<Ship> {
        return database.shipsById.values.asSequence()
    }

    /**
     * @since 1.0.0
     *
     * Get version of the api wrapper
     */
    fun getVersion(): Version {
        return Version(AtagoInfo.VERSION, database.lastCheckDate, database.remoteJsonVersion)
    }

    /**
     * @since 1.0.0
     *
     * Reload database from remote json
     */
    fun reloadDatabase() {
        try {
            database.loadDatabase()
        } catch (e: Exception) {
            throw ApiException("Could not reload database because: ${e.message}")
        }
    }

    /**
     * @since 4.0.0
     *
     * Get information about an equipment by name
     */
    fun getEquipmentByName(name: String, lang: Lang = Lang.ANY): Equipment {
        return database.findEquipment(name, lang) ?: throw EquipmentNotFoundException("Could not find equipment with name: $name")
    }
}
