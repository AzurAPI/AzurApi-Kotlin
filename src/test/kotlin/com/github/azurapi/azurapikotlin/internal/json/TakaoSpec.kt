package com.github.azurapi.azurapikotlin.internal.json

import ch.tutteli.atrium.api.fluent.en_GB.isNotEmpty
import ch.tutteli.atrium.api.verbs.expect
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class TakaoSpec : Spek({
    lateinit var takao: Takao

    beforeEachTest {
        takao = Takao()
    }

    describe("Takao") {
        it("should init json database") {
            expect(takao.shipsById).isNotEmpty()
            expect(takao.shipsByEnName).isNotEmpty()
            expect(takao.shipsByCnName).isNotEmpty()
            expect(takao.shipsByJpName).isNotEmpty()
            expect(takao.shipsByKrName).isNotEmpty()
        }
    }
})
