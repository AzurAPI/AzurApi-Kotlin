package com.github.azurapi.azurapikotlin.json

import com.github.kittinunf.fuel.httpGet
import io.kotlintest.TestCase
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TakaoTestCase: StringSpec() {

    lateinit var takao: Takao

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        takao = Takao()
    }

    init {
        "it should get remote json" {
            val (_, response, _) = TakaoInfo.JSON_SOURCE
                .httpGet()
                .response()
            response.statusCode.shouldBe(200)
        }

        "it should init json database" {
            takao.shipsById.isEmpty().shouldBeFalse()
            takao.shipsByName.isEmpty().shouldBeFalse()
        }
    }
}