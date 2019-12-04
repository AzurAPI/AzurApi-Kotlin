package com.github.azurapi.azurapikotlin.utils

import com.github.azurapi.azurapikotlin.internal.entities.*
import com.github.azurapi.azurapikotlin.internal.exceptions.DatabaseException
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.NumberFormatException

object ShipParser {

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
                enClient = json.optString("EN Client"),
                cnClient = json.optString("CN Client"),
                jpClient = json.optString("JP Client"),
                obtainedFrom = json.getString("Obtained From"),
                cost = try {
                    json.optString("Cost").toInt()
                } catch (e: NumberFormatException) {
                    0
                },
                isLive2D = json.getString("Live2D Model") == "Yes"
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
                speed = json.getInt("Speed"),
                accuracy = json.getInt("Accuracy (Hit)"),
                antiAir = json.getInt("Anti-air"),
                antiSub = json.getInt("Anti-submarine warfare"),
                armor = json.getString("Armor"),
                aviation = json.getInt("Aviation"),
                evasion = json.getInt("Evasion"),
                firepower = json.getInt("Firepower"),
                health = json.getInt("Health"),
                luck = json.getInt("Luck"),
                // FIXME: it should be defined
                oil = json.optInt("Oil consumption"),
                reload = json.getInt("Reload"),
                torpedo = json.getInt("Torpedo")
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
                        "Level 120"
                    )
                ),
                level100 = jsonToStatsDetails(
                    json.getJSONObject(
                        "Level 100"
                    )
                ),
                base = jsonToStatsDetails(
                    json.getJSONObject(
                        "Base Stats"
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
                voice = json.optString("voice")
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
                buildTime = json.optString("buildTime"),
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
}