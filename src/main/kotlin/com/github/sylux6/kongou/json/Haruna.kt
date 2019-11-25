package com.github.sylux6.kongou.json

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result;

/**
 * JSON deserializer object
 */
object Haruna {

    fun loadShips() {
        HarunaInfo.JSON_SOURCE
            .httpGet()
            .responseJson { request, response, result ->
                when(result) {
                    is Result.Failure -> {
                        println(result.getException())
                    }
                    is Result.Success -> {
                        println(result.get())
                    }
                }
            }
        println("ok")
    }
}