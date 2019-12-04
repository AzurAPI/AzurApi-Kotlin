package com.github.azurapi.azurapikotlin.api

import io.kotlintest.TestCase
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.specs.StringSpec

class AtagoTestCase : StringSpec() {

    lateinit var atago: Atago

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        atago = Atago()
    }

    init {
        "test" {
            true.shouldBeTrue()
        }
    }
}