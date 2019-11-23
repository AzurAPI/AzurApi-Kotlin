package com.github.sylux6.kongou.json

import com.github.kittinunf.fuel.httpGet
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HarunaTests {

    @Test
    fun `json source is up`() {
        val (_, response, _) = HarunaInfo.JSON_SOURCE
            .httpGet()
            .response()

        Assertions.assertEquals(response.statusCode, 200)
    }

    @Test
    fun `for testing`() {
        Haruna.loadShips()
    }
}