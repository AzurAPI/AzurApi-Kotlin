package com.github.azurapi.azurapikotlin.internal.utils.parser

import com.github.azurapi.azurapikotlin.internal.entities.DamageStats
import com.github.azurapi.azurapikotlin.internal.entities.Equipment
import com.github.azurapi.azurapikotlin.internal.entities.EquipmentFit
import com.github.azurapi.azurapikotlin.internal.entities.EquipmentFits
import com.github.azurapi.azurapikotlin.internal.entities.EquipmentMiscellaneous
import com.github.azurapi.azurapikotlin.internal.entities.EquipmentStats
import com.github.azurapi.azurapikotlin.internal.entities.EquipmentType
import com.github.azurapi.azurapikotlin.internal.entities.RateOfFireStats
import com.github.azurapi.azurapikotlin.internal.entities.Tier
import com.github.azurapi.azurapikotlin.internal.entities.TypeValue
import com.github.azurapi.azurapikotlin.internal.entities.UnitTypeValue
import com.github.azurapi.azurapikotlin.internal.entities.VolleyStats
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import org.json.JSONException
import org.json.JSONObject

internal fun jsonToVolleyStats(json: JSONObject): VolleyStats {
    return VolleyStats(
        type = json.getString("type"),
        multiplier = json.getInt("multiplier"),
        count = json.getInt("count"),
        unit = json.getString("unit"),
        formatted = json.getString("formatted")
    )
}

internal fun jsonToUnitTypeValue(json: JSONObject): UnitTypeValue {
    return UnitTypeValue(
        type = json.getString("type"),
        value = json.getInt("value"),
        unit = json.getString("unit"),
        formatted = json.getString("formatted")
    )
}

internal fun jsonToDamageStats(json: JSONObject): DamageStats {
    return DamageStats(
        type = json.getString("type"),
        min = json.getInt("min"),
        max = json.getInt("max"),
        multiplier = json.getInt("multiplier"),
        formatted = json.getString("formatted")
    )
}

internal fun jsonToRateOfFireStats(json: JSONObject): RateOfFireStats {
    return RateOfFireStats(
        type = json.getString("type"),
        min = json.getString("min").filterNot { it == 's' }.toFloat(),
        max = json.getString("max").filterNot { it == 's' }.toFloat(),
        per = json.getString("per"),
        formatted = json.getString("formatted")
    )
}

internal fun jsonToTypeValue(json: JSONObject): TypeValue {
    return TypeValue(
        type = json.getString("types"),
        value = json.getInt("value"),
        formatted = json.getString("formatted")
    )
}

internal fun jsonToEquipmentStats(json: JSONObject): EquipmentStats {
    return EquipmentStats(
        firepower = jsonToTypeValue(json.getJSONObject("firepower")),
        antiAir = jsonToTypeValue(json.getJSONObject("antiAir")),
        damage = jsonToDamageStats(json.getJSONObject("damage")),
        rateOfFire = jsonToRateOfFireStats(json.getJSONObject("rateOfFire")),
        spread = jsonToUnitTypeValue(json.getJSONObject("spread")),
        angle = jsonToUnitTypeValue(json.getJSONObject("angle")),
        range = jsonToTypeValue(json.getJSONObject("range")),
        volley = jsonToVolleyStats(json.getJSONObject("volley")),
        volleyTime = jsonToTypeValue(json.getJSONObject("volleyTime")),
        coefficient = jsonToTypeValue(json.getJSONObject("coefficient")),
        ammoType = jsonToTypeValue(json.getJSONObject("ammoType")),
        characteristic = jsonToTypeValue(json.getJSONObject("characteristic"))
    )
}

internal fun jsonToEquipmentTiers(json: JSONObject): Map<String, Tier> {
    val tiers = HashMap<String, Tier>()
    for (key in json.keys()) {
        val tier = json.getJSONObject(key)
        tiers[key] = Tier(
            tier = tier.getString("name"),
            rarity = tier.getString("rarity"),
            stars = jsonToStars(tier.getJSONObject("stars"))!!,
            stats = jsonToEquipmentStats(tier.getJSONObject("stats"))
        )
    }
    return mapOf()
}

internal fun jsonToEquipmentMisc(json: JSONObject): EquipmentMiscellaneous {
    return EquipmentMiscellaneous(
        obtainedFrom = json.getString("obtainedFrom"),
        notes = json.getString("notes"),
        animation = json.getString("animation")
    )
}

internal fun jsonToEquipmentFits(json: JSONObject): EquipmentFits {
    fun stringToEquipmentFit(s: String): EquipmentFit {
        return when (s) {
            "primary" -> EquipmentFit.PRIMARY
            "secondary" -> EquipmentFit.SECONDARY
            else -> EquipmentFit.NONE
        }
    }
    return EquipmentFits(
        destroyer = stringToEquipmentFit(json.optString("destroyer")),
        lightCruiser = stringToEquipmentFit(json.optString("lightCruiser")),
        heavyCruiser = stringToEquipmentFit(json.optString("heavyCruiser")),
        monitor = stringToEquipmentFit(json.optString("monitor")),
        largeCruiser = stringToEquipmentFit(json.optString("largeCruiser")),
        battleship = stringToEquipmentFit(json.optString("battleship")),
        battlecruiser = stringToEquipmentFit(json.optString("battlecruiser")),
        aviationBattleship = stringToEquipmentFit(json.optString("aviationBattleship")),
        aircraftCarrier = stringToEquipmentFit(json.optString("aircraftCarrier")),
        lightCarrier = stringToEquipmentFit(json.optString("lightCarrier")),
        repairShip = stringToEquipmentFit(json.optString("repairShip")),
        submarine = stringToEquipmentFit(json.optString("submarine")),
        submarineCarrier = stringToEquipmentFit(json.optString("submarineCarrier"))
    )
}

internal fun jsonToEquipmentType(json: JSONObject): EquipmentType {
    return EquipmentType(
        focus = json.getString("focus"),
        name = json.getString("name")
    )
}

internal fun jsonToEquipment(json: JSONObject, equipmentId: String): Equipment {
    try {
        return Equipment(
            wikiUrl = json.getString("wikiUrl"),
            category = json.getString("category"),
            names = jsonToNames(json.getJSONObject("names")),
            type = jsonToEquipmentType(json.getJSONObject("type")),
            nationality = json.getString("nationality"),
            image = json.getString("image"),
            fits = jsonToEquipmentFits(json.getJSONObject("fits")),
            misc = jsonToEquipmentMisc(json.getJSONObject("misc")),
            tiers = jsonToEquipmentTiers(json.getJSONObject("tiers"))
        )
    } catch (e: JSONException) {
        throw DatabaseException("Could not parse equipment#$equipmentId: (${e.message})")
    }
}
