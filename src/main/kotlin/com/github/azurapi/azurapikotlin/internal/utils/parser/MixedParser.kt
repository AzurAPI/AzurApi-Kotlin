package com.github.azurapi.azurapikotlin.internal.utils.parser

import com.github.azurapi.azurapikotlin.internal.entities.Name
import com.github.azurapi.azurapikotlin.internal.entities.Stars
import org.json.JSONObject

internal fun jsonToNames(json: JSONObject): Name {
    return Name(
        jp = json.optString("jp"),
        en = json.getString("en"),
        cn = json.optString("cn"),
        kr = json.optString("kr")
    )
}

internal fun jsonToStars(json: JSONObject?): Stars? {
    if (json == null) {
        return null
    }
    return Stars(
        stars = json.getString("stars"),
        value = json.getInt("value")
    )
}
