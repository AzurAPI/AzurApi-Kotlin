package com.github.azurapi.azurapikotlin.api

import com.github.azurapi.azurapikotlin.internal.entities.Lang
import com.github.azurapi.azurapikotlin.internal.exceptions.ShipNotFoundException
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class AtagoTestCase : StringSpec() {

    init {
        "it should find Atago" {
            Atago.getShipByName("aTa  gOo", Lang.EN).names.en.shouldBe("Atago")
            Atago.getShipByName("Atago", Lang.EN).names.en.shouldBe("Atago")
            Atago.getShipByName("犬", Lang.CN).names.en.shouldBe("Atago")
            Atago.getShipByName("愛宕", Lang.JP).names.en.shouldBe("Atago")
            Atago.getShipByName("아타고", Lang.KR).names.en.shouldBe("Atago")

            Atago.getShipByName("Atago").names.en.shouldBe("Atago")
            Atago.getShipByName("犬").names.en.shouldBe("Atago")
            Atago.getShipByName("愛宕").names.en.shouldBe("Atago")
            Atago.getShipByName("아타고").names.en.shouldBe("Atago")
        }

        "it should not find Atago" {
            shouldThrow<ShipNotFoundException> {
                Atago.getShipByName("Atago", Lang.CN)
            }.message.shouldBe("Could not find ship with name: Atago")
            shouldThrow<ShipNotFoundException> {
                Atago.getShipByName("Atago", Lang.KR)
            }.message.shouldBe("Could not find ship with name: Atago")
            shouldThrow<ShipNotFoundException> {
                Atago.getShipByName("Atago", Lang.JP)
            }.message.shouldBe("Could not find ship with name: Atago")
            shouldThrow<ShipNotFoundException> {
                Atago.getShipByName("愛宕", Lang.EN)
            }.message.shouldBe("Could not find ship with name: 愛宕")
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

        "it should update database" {
            val oldDate = Atago.getVersion().lastUpdatedApi
            Atago.reloadDatabase()
            (Atago.getVersion().lastUpdatedApi > oldDate).shouldBeTrue()
        }
    }
}