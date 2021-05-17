package com.github.azurapi.azurapikotlin.internal.utils.parser

import com.github.azurapi.azurapikotlin.internal.entities.*
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

private fun jsonToRetrofit(json: JSONObject?): RetrofitProject? {
    if (json == null)
    {
        return null
    }
    try {
        return RetrofitProject(
            id = json.getString("id"),
            grade = json.getString("grade"),
            attributes = json.getString("attributes"),
            materials = json.getString("materials"),
            coins = json.getInt("coins"),
            level = json.getInt("level"),
            levelBreakLevel = json.getInt("levelBreakLevel"),
            levelBreakStars = json.getString("levelBreakStars"),
            recurrence = json.getInt("recurrence"),
            requires = json.getString("requires")
        )
    } catch (e : JSONException) {
        throw e
    }
}

private fun jsonToTechBonus(json: JSONObject?): TechBonus? {
    if (json == null)
    {
        return null
    }
    try {
        return TechBonus(
            collection = json.optString("collection"),
            maxLevel = json.optString("maxLevel")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToTechPoint(json: JSONObject): TechPoint {
    try {
        return TechPoint(
            collection = json.getInt("collection"),
            maxLimitBreak = json.getInt("maxLimitBreak"),
            maxLevel = json.getInt("maxLevel"),
            total = json.getInt("total")
        )
    } catch (e: JSONException) {
        throw e
    }
}

private fun jsonToNames(json: JSONObject): Name {
    try {
        return Name(
            code = json.optString("code"),
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
            } catch (e: Exception) {
                0
            },

            live2dModel = json.getBoolean("live2dModel")
        )
    } catch (e: JSONException) {
        throw e
    }
}

/**
 * TODO: create an experiment to check if cn, bg, nobg, background is working
 * */
private fun jsonToSkins(jsonArray: JSONArray): List<Skin> {
    try {
        return jsonArray.map { skin ->
            skin as JSONObject
            Skin(
                name = skin.getString("name"),
                chibi = skin.getString("chibi"),
                image = skin.getString("image"),

                cn = jsonToUrl(
                    skin.optJSONObject(
                        "cn"
                    )
                ),

                bg = jsonToUrl(
                    skin.getJSONObject(
                        "bg"
                    )
                ),

                nobg = jsonToUrl(
                    skin.getJSONObject(
                        "nobg"
                    )
                ),

                background = skin.getString("background"),

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
            speed = json.optInt("speed"),
            accuracy = json.optInt("accuracy"),
            antiAir = json.optInt("antiair"),
            antiSub = json.optInt("antisubmarineWarfare"),
            armor = json.optString("armor"),
            aviation = json.optInt("aviation"),
            evasion = json.optInt("evasion"),
            firepower = json.optInt("firepower"),
            health = json.optInt("health"),
            luck = json.optInt("luck"),
            oil = json.optInt("oilConsumption"),
            reload = json.optInt("reload"),
            torpedo = json.optInt("torpedo")
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
            ),
            level100Retrofit = jsonToStatsDetails(
                json.getJSONObject("level100Retrofit")
            ),

            level120Retrofit = jsonToStatsDetails(
                json.getJSONObject("level120Retrofit")
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
