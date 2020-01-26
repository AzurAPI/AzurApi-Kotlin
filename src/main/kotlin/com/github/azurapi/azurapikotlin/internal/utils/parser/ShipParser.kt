package com.github.azurapi.azurapikotlin.internal.utils.parser

import com.github.azurapi.azurapikotlin.internal.entities.Miscellaneous
import com.github.azurapi.azurapikotlin.internal.entities.Name
import com.github.azurapi.azurapikotlin.internal.entities.Ship
import com.github.azurapi.azurapikotlin.internal.entities.ShipConstruction
import com.github.azurapi.azurapikotlin.internal.entities.Skin
import com.github.azurapi.azurapikotlin.internal.entities.SkinInfo
import com.github.azurapi.azurapikotlin.internal.entities.Stars
import com.github.azurapi.azurapikotlin.internal.entities.Stats
import com.github.azurapi.azurapikotlin.internal.entities.StatsDetails
import com.github.azurapi.azurapikotlin.internal.entities.Url
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

private fun jsonToNames(json: JSONObject): Name {
    try {
        return Name(
            jp = json.optString("jp"),
            en = json.getString("en"),
            cn = json.optString("cn"),
            kr = json.optString("kr")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToSkinInfo(json: JSONObject?): SkinInfo? {
    if (json == null) {
        return null
    }
    try {
        return SkinInfo(
            enClient = json.optString("enClient"),
            cnClient = json.optString("cnClient"),
            jpClient = json.optString("jpClient"),
            obtainedFrom = json.optString("obtainedFrom"),
            cost = try {
                json.optString("cost").toInt()
            } catch (e: NumberFormatException) {
                0
            },
            isLive2D = json.getBoolean("live2dModel")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToSkins(jsonArray: JSONArray): List<Skin> {
    try {
        return jsonArray.map { skin ->
            skin as JSONObject
            Skin(
                name = skin.getString("name"),
                image = skin.getString("image"),
                background = skin.optString("background"),
                chibi = skin.optString("chibi"),
                info = jsonToSkinInfo(
                    skin.optJSONObject(
                        "info"
                    )
                )
            )
        }
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToStatsDetails(json: JSONObject): StatsDetails {
    try {
        return StatsDetails(
            speed = json.getInt("speed"),
            accuracy = json.getInt("accuracy"),
            antiAir = json.getInt("antiair"),
            antiSub = json.getInt("antisubmarineWarfare"),
            armor = json.getString("armor"),
            aviation = json.getInt("aviation"),
            evasion = json.getInt("evasion"),
            firepower = json.getInt("firepower"),
            health = json.getInt("health"),
            luck = json.getInt("luck"),
            // FIXME: it should be defined
            oil = json.optInt("oilConsumption"),
            reload = json.getInt("reload"),
            torpedo = json.getInt("torpedo")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToStats(json: JSONObject?): Stats? {
    if (json == null) {
        return null
    }
    try {
        return Stats(
            level120 = jsonToStatsDetails(
                json.getJSONObject(
                    "level120"
                )
            ),
            level100 = jsonToStatsDetails(
                json.getJSONObject(
                    "level100"
                )
            ),
            base = jsonToStatsDetails(
                json.getJSONObject(
                    "baseStats"
                )
            )
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToStars(json: JSONObject?): Stars? {
    if (json == null) {
        return null
    }
    try {
        return Stars(
            stars = json.getString("stars"),
            value = json.getInt("value")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToUrl(json: JSONObject?): Url? {
    if (json == null) {
        return null
    }
    try {
        return Url(
            name = json.getString("name"),
            url = json.getString("url")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToConstruction(json: JSONObject?): ShipConstruction? {
    if (json == null) {
        return null
    }
    try {
        val availability = json.getJSONObject("availableIn")
        // FIXME: not always a boolean
        return ShipConstruction(
            constructionTime = json.getString("constructionTime"),
            light = availability.optBoolean("light", true),
            heavy = availability.optBoolean("heavy", true),
            aviation = availability.optBoolean("aviation", true),
            limited = availability.optBoolean("limited", true),
            exchange = availability.optBoolean("exchange", true)
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToMiscellaneous(json: JSONObject?): Miscellaneous? {
    if (json == null) {
        return null
    }
    try {
        return Miscellaneous(
            artist = json.optString("artist"),
            web = jsonToUrl(
                json.optJSONObject(
                    "web"
                )
            ),
            pixiv = jsonToUrl(
                json.optJSONObject(
                    "pixiv"
                )
            ),
            twitter = jsonToUrl(
                json.optJSONObject(
                    "twitter"
                )
            ),
            voice = jsonToUrl(
                json.optJSONObject(
                    "voice"
                )
            )
        )
    } catch (e: JSONException) {
        throw e
    }
}

fun jsonToShip(json: JSONObject, shipId: String): Ship {
    try {
        return Ship(
            wikiUrl = json.getString("wikiUrl"),
            id = json.getString("id"),
            hullType = json.getString("hullType"),
            nationality = json.getString("nationality"),
            rarity = json.getString("rarity"),
            thumbnail = json.getString("thumbnail"),
            shipClass = json.optString("class"),
            names = jsonToNames(
                json.getJSONObject(
                    "names"
                )
            ),
            skins = jsonToSkins(
                json.getJSONArray(
                    "skins"
                )
            ),
            stats = jsonToStats(
                json.optJSONObject(
                    "stats"
                )
            ),
            stars = jsonToStars(
                json.optJSONObject(
                    "stars"
                )
            ),
            construction = jsonToConstruction(
                json.optJSONObject(
                    "construction"
                )
            ),
            misc = jsonToMiscellaneous(
                json.optJSONObject(
                    "misc"
                )
            )
        )
    } catch (e: JSONException) {
        throw DatabaseException("Could not parse ship#$shipId: (${e.message})")
    }
}