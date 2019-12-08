package com.github.azurapi.azurapikotlin.api

import io.kotlintest.TestCase
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AtagoTestCase : StringSpec() {

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
    }

    init {
        "it should find Atago" {
            Atago.getShipByName("aTa  gOo").names.en.shouldBe("Atago")
        }

        "it should find Belfast" {
            Atago.getShipByName("Belfast").names.en.shouldBe("Belfast")
            Atago.getShipByName("belfast").names.en.shouldBe("Belfast")
            Atago.getShipByName("belfap").names.en.shouldBe("Belfast")
            Atago.getShipByName("baefast").names.en.shouldBe("Belfast")
        }

        "it should find Jeanne d'Arc" {
            Atago.getShipByName("Jeanne d'Arc").names.en.shouldBe("Jeanne d'Arc")
            Atago.getShipByName("jeanne").names.en.shouldBe("Jeanne d'Arc")
        }

        "it should return Atago by her id" {
            Atago.getShipById("201").names.en.shouldBe("Atago")
        }

        "it should return a Version object of the api" {
            val version = Atago.getVersion()
            version.databaseVersion.shouldNotBeNull()
            version.lastUpdatedApi.shouldNotBeNull()
            version.lastUpdatedDatabase.shouldNotBeNull()
            version.apiVersion.shouldNotBeNull()
        }
    }
}