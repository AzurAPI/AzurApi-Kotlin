package com.github.azurapi.azurapikotlin.internal.json

import ch.tutteli.atrium.api.fluent.en_GB.isNotEmpty
import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import com.github.azurapi.azurapikotlin.internal.utils.info.TakaoInfo
import com.github.kittinunf.fuel.httpGet
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class TakaoTestCase : Spek({
    lateinit var takao: Takao

    beforeEachTest {
        takao = Takao()
    }

    describe("Takao") {
        it("should get remote json") {
            val (_, response, _) = TakaoInfo.JSON_SHIP
                .httpGet()
                .response()
            expect(response.statusCode).toBe(200)
        }

        it("should init json database") {
            expect(takao.shipsById).isNotEmpty()
            expect(takao.shipsByEnName).isNotEmpty()
            expect(takao.shipsByCnName).isNotEmpty()
            expect(takao.shipsByJpName).isNotEmpty()
            expect(takao.shipsByKrName).isNotEmpty()
        }
    }
})
