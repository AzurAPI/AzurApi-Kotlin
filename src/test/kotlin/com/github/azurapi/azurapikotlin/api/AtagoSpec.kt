package com.github.azurapi.azurapikotlin.api

import ch.tutteli.atrium.api.fluent.en_GB.message
import ch.tutteli.atrium.api.fluent.en_GB.startsWith
import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.fluent.en_GB.toThrow
import ch.tutteli.atrium.api.verbs.expect
import com.github.azurapi.azurapikotlin.internal.entities.Lang
import com.github.azurapi.azurapikotlin.internal.exceptions.ShipNotFoundException
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class AtagoSpec : Spek({
    describe("Atago") {
        it("should find Atago") {
            expect(Atago.getShipByName("aTa  gOo", Lang.EN).names.en).toBe("Atago")
            expect(Atago.getShipByName("Atago", Lang.EN).names.en).toBe("Atago")
            expect(Atago.getShipByName("犬", Lang.CN).names.en).toBe("Atago")
            expect(Atago.getShipByName("愛宕", Lang.JP).names.en).toBe("Atago")
            expect(Atago.getShipByName("아타고", Lang.KR).names.en).toBe("Atago")

            expect(Atago.getShipByName("Atago").names.en).toBe("Atago")
            expect(Atago.getShipByName("犬").names.en).toBe("Atago")
            expect(Atago.getShipByName("愛宕").names.en).toBe("Atago")
            expect(Atago.getShipByName("아타고").names.en).toBe("Atago")
        }

        it("should not find Atago") {
            expect { Atago.getShipByName("Atago", Lang.CN) }
                .toThrow<ShipNotFoundException>().message.startsWith("Could not find ship with name: Atago")
            expect { Atago.getShipByName("Atago", Lang.KR) }
                .toThrow<ShipNotFoundException>().message.startsWith("Could not find ship with name: Atago")
            expect { Atago.getShipByName("Atago", Lang.JP) }
                .toThrow<ShipNotFoundException>().message.startsWith("Could not find ship with name: Atago")
            expect { Atago.getShipByName("愛宕", Lang.EN) }
                .toThrow<ShipNotFoundException>().message.startsWith("Could not find ship with name: 愛宕")
        }

        it("should find Belfast") {
            expect(Atago.getShipByName("Belfast").names.en).toBe("Belfast")
            expect(Atago.getShipByName("belfast").names.en).toBe("Belfast")
            expect(Atago.getShipByName("belfap").names.en).toBe("Belfast")
            expect(Atago.getShipByName("baefast").names.en).toBe("Belfast")
        }

        it("should find Jeanne d'Arc") {
            expect(Atago.getShipByName("Jeanne d'Arc").names.en).toBe("Jeanne d'Arc")
            expect(Atago.getShipByName("jeanne").names.en).toBe("Jeanne d'Arc")
        }

        it("should return Atago by her id") {
            expect(Atago.getShipById("201").names.en).toBe("Atago")
        }

        it("should return a Version object of the api") {
//            val version = Atago.getVersion()
//            version.databaseVersion.shouldNotBeNull()
//            version.lastUpdatedApi.shouldNotBeNull()
//            version.lastUpdatedDatabase.shouldNotBeNull()
//            version.apiVersion.shouldNotBeNull()
        }

        it("should update database") {
            val oldDate = Atago.getVersion().lastUpdatedApi
            Atago.reloadDatabase()
            expect(Atago.getVersion().lastUpdatedApi > oldDate).toBe(true)
        }
    }
})
