package com.github.azurapi.azurapikotlin.json

import com.github.azurapi.azurapikotlin.utils.ShipParser
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.string.shouldBeEmpty
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.json.JSONObject

class ShipParserTestCase: StringSpec() {

    init {
        "it should correctly parse Atago" {
            val json = JSONObject("""
            {"201": {
                "wikiUrl": "https://azurlane.koumakan.jp/Atago",
                "id": "201",
                "names": {
                    "en": "Atago",
                    "cn": "爱宕",
                    "jp": "愛宕",
                    "kr": "아타고"
                },
                "class": "Takao",
                "nationality": "Sakura Empire",
                "hullType": "Heavy Cruiser",
                "thumbnail": "https://azurlane.koumakan.jp/w/images/0/0c/AtagoIcon.png",
                "skins": [
                    {
                        "name": "Default",
                        "image": "https://azurlane.koumakan.jp/w/images/thumb/6/65/Atago.png/642px-Atago.png",
                        "background": "https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png",
                        "chibi": "https://azurlane.koumakan.jp/w/images/3/33/AtagoChibi.png",
                        "info": {
                            "Obtained From": "Default",
                            "Live2D Model": "No"
                        }
                    },
                    {
                        "name": "Oath",
                        "image": "https://azurlane.koumakan.jp/w/images/thumb/5/58/AtagoWedding.png/668px-AtagoWedding.png",
                        "background": "https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png",
                        "chibi": "https://azurlane.koumakan.jp/w/images/1/1e/AtagoWeddingChibi.png",
                        "info": {
                            "EN Client": "Lily-White Vow",
                            "CN Client": "",
                            "JP Client": "White Promise",
                            "Obtained From": "Oath",
                            "Live2D Model": "No"
                        }
                    },
                    {
                        "name": "Summer March",
                        "image": "https://azurlane.koumakan.jp/w/images/thumb/3/36/AtagoSummer.png/352px-AtagoSummer.png",
                        "background": "https://azurlane.koumakan.jp/w/images/1/1c/Skin_BG_106.png",
                        "chibi": "https://azurlane.koumakan.jp/w/images/0/01/AtagoSummerChibi.png",
                        "info": {
                            "EN Client": "Summer March",
                            "CN Client": "",
                            "JP Client": "Midsummer March",
                            "Obtained From": "Skin Shop",
                            "Cost": "700",
                            "Live2D Model": "Yes"
                        }
                    },
                    {
                        "name": "Hallmarks of Winter",
                        "image": "https://azurlane.koumakan.jp/w/images/thumb/4/4e/AtagoNew_Year.png/462px-AtagoNew_Year.png",
                        "background": "https://azurlane.koumakan.jp/w/images/5/5b/Skin_BG_101.png",
                        "chibi": "https://azurlane.koumakan.jp/w/images/8/8b/AtagoNew_YearChibi.png",
                        "info": {
                            "EN Client": "Hallmarks of Winter",
                            "CN Client": "",
                            "JP Client": "Features of Winter",
                            "Obtained From": "Skin Shop",
                            "Cost": "780",
                            "Live2D Model": "No"
                        }
                    },
                    {
                        "name": "School Traumerei",
                        "image": "https://azurlane.koumakan.jp/w/images/thumb/9/96/AtagoSchool.png/448px-AtagoSchool.png",
                        "background": "https://azurlane.koumakan.jp/w/images/6/64/Skin_BG_103.png",
                        "chibi": "https://azurlane.koumakan.jp/w/images/4/49/AtagoSchoolChibi.png",
                        "info": {
                            "EN Client": "School Traumerei",
                            "CN Client": "",
                            "JP Client": "School Traumerei",
                            "Obtained From": "Skin Shop",
                            "Cost": "880",
                            "Live2D Model": "No"
                        }
                    }
                ],
                "buildTime": "02:05:00",
                "rarity": "Super Rare",
                "stars": {
                    "stars": "★★★☆☆☆",
                    "value": 3
                },
                "stats": {
                    "Level 120": {
                        "Health": "4295",
                        "Armor": "Medium",
                        "Reload": "175",
                        "Luck": "48",
                        "Firepower": "270",
                        "Torpedo": "245",
                        "Evasion": "79",
                        "Speed": "31",
                        "Anti-air": "178",
                        "Aviation": "0",
                        "Oil consumption": "12",
                        "Accuracy (Hit)": "134",
                        "Anti-submarine warfare": "0"
                    },
                    "Level 100": {
                        "Health": "3818",
                        "Armor": "Medium",
                        "Reload": "152",
                        "Luck": "48",
                        "Firepower": "236",
                        "Torpedo": "213",
                        "Evasion": "33",
                        "Speed": "31",
                        "Anti-air": "155",
                        "Aviation": "0",
                        "Oil consumption": "12",
                        "Accuracy (Hit)": "119",
                        "Anti-submarine warfare": "0"
                    },
                    "Base Stats": {
                        "Health": "738",
                        "Armor": "Medium",
                        "Reload": "64",
                        "Luck": "48",
                        "Firepower": "50",
                        "Torpedo": "45",
                        "Evasion": "13",
                        "Speed": "31",
                        "Anti-air": "33",
                        "Aviation": "0",
                        "Oil consumption": "4",
                        "Accuracy (Hit)": "46",
                        "Anti-submarine warfare": "0"
                    }
                },
                "misc": {
                    "artist": "木shiyo",
                    "web": {
                        "name": "木shiyo",
                        "url": "https://weibo.com/u/2481339344"
                    },
                    "pixiv": {
                        "name": "木shiyo",
                        "url": "https://www.pixiv.net/member.php?id=40222"
                    },
                    "twitter": {
                        "name": "木shiyo",
                        "url": "https://twitter.com/kishiyo1943"
                    },
                    "voice": "Ai Kayano"
                }
            }}
        """.trimIndent())
            val atago = ShipParser.jsonToShip(json.optJSONObject("201"), "201")

            atago.wikiUrl.shouldBe("https://azurlane.koumakan.jp/Atago")
            atago.id.shouldBe("201")
            atago.names.en.shouldBe("Atago")
            atago.names.cn.shouldBe("爱宕")
            atago.names.jp.shouldBe("愛宕")
            atago.names.kr.shouldBe("아타고")
            atago.shipClass.shouldBe("Takao")
            atago.nationality.shouldBe("Sakura Empire")
            atago.hullType.shouldBe("Heavy Cruiser")
            atago.thumbnail.shouldBe("https://azurlane.koumakan.jp/w/images/0/0c/AtagoIcon.png")

            atago.skins.shouldHaveSize(5)
            atago.skins[0].name.shouldBe("Default")
            atago.skins[0].image.shouldBe("https://azurlane.koumakan.jp/w/images/thumb/6/65/Atago.png/642px-Atago.png")
            atago.skins[0].background.shouldBe("https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png")
            atago.skins[0].chibi.shouldBe("https://azurlane.koumakan.jp/w/images/3/33/AtagoChibi.png")
            atago.skins[0].info.shouldNotBeNull()
            atago.skins[0].info!!.enClient.shouldBeEmpty()
            atago.skins[0].info!!.cnClient.shouldBeEmpty()
            atago.skins[0].info!!.jpClient.shouldBeEmpty()
            atago.skins[0].info!!.cost.shouldBe(0)
            atago.skins[0].info!!.obtainedFrom.shouldBe("Default")
            atago.skins[0].info!!.isLive2D.shouldBeFalse()
            atago.skins[1].name.shouldBe("Oath")
            atago.skins[1].image.shouldBe("https://azurlane.koumakan.jp/w/images/thumb/5/58/AtagoWedding.png/668px-AtagoWedding.png")
            atago.skins[1].background.shouldBe("https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png")
            atago.skins[1].chibi.shouldBe("https://azurlane.koumakan.jp/w/images/1/1e/AtagoWeddingChibi.png")
            atago.skins[1].info.shouldNotBeNull()
            atago.skins[1].info!!.enClient.shouldBe("Lily-White Vow")
            atago.skins[1].info!!.cnClient.shouldBeEmpty()
            atago.skins[1].info!!.jpClient.shouldBe("White Promise")
            atago.skins[1].info!!.cost.shouldBe(0)
            atago.skins[1].info!!.obtainedFrom.shouldBe("Oath")
            atago.skins[1].info!!.isLive2D.shouldBeFalse()

            atago.skins[2].name.shouldBe("Summer March")
            atago.skins[2].image.shouldBe("https://azurlane.koumakan.jp/w/images/thumb/3/36/AtagoSummer.png/352px-AtagoSummer.png")
            atago.skins[2].background.shouldBe("https://azurlane.koumakan.jp/w/images/1/1c/Skin_BG_106.png")
            atago.skins[2].chibi.shouldBe("https://azurlane.koumakan.jp/w/images/0/01/AtagoSummerChibi.png")
            atago.skins[2].info.shouldNotBeNull()
            atago.skins[2].info!!.enClient.shouldBe("Summer March")
            atago.skins[2].info!!.cnClient.shouldBe("")
            atago.skins[2].info!!.jpClient.shouldBe("Midsummer March")
            atago.skins[2].info!!.cost.shouldBe(700)
            atago.skins[2].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[2].info!!.isLive2D.shouldBeTrue()

            atago.skins[3].name.shouldBe("Hallmarks of Winter")
            atago.skins[3].image.shouldBe("https://azurlane.koumakan.jp/w/images/thumb/4/4e/AtagoNew_Year.png/462px-AtagoNew_Year.png")
            atago.skins[3].background.shouldBe("https://azurlane.koumakan.jp/w/images/5/5b/Skin_BG_101.png")
            atago.skins[3].chibi.shouldBe("https://azurlane.koumakan.jp/w/images/8/8b/AtagoNew_YearChibi.png")
            atago.skins[3].info.shouldNotBeNull()
            atago.skins[3].info!!.enClient.shouldBe("Hallmarks of Winter")
            atago.skins[3].info!!.cnClient.shouldBeEmpty()
            atago.skins[3].info!!.jpClient.shouldBe("Features of Winter")
            atago.skins[3].info!!.cost.shouldBe(780)
            atago.skins[3].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[3].info!!.isLive2D.shouldBeFalse()

            atago.skins[4].name.shouldBe("School Traumerei")
            atago.skins[4].image.shouldBe("https://azurlane.koumakan.jp/w/images/thumb/9/96/AtagoSchool.png/448px-AtagoSchool.png")
            atago.skins[4].background.shouldBe("https://azurlane.koumakan.jp/w/images/6/64/Skin_BG_103.png")
            atago.skins[4].chibi.shouldBe("https://azurlane.koumakan.jp/w/images/4/49/AtagoSchoolChibi.png")
            atago.skins[4].info.shouldNotBeNull()
            atago.skins[4].info!!.enClient.shouldBe("School Traumerei")
            atago.skins[4].info!!.cnClient.shouldBeEmpty()
            atago.skins[4].info!!.jpClient.shouldBe("School Traumerei")
            atago.skins[4].info!!.cost.shouldBe(880)
            atago.skins[4].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[4].info!!.isLive2D.shouldBeFalse()

            atago.buildTime.shouldBe("02:05:00")
            atago.rarity.shouldBe("Super Rare")

            atago.stars!!.stars.shouldBe("★★★☆☆☆")
            atago.stars!!.value.shouldBe(3)

            atago.stats!!.level120.health.shouldBe(4295)
            atago.stats!!.level120.armor.shouldBe("Medium")
            atago.stats!!.level120.reload.shouldBe(175)
            atago.stats!!.level120.luck.shouldBe(48)
            atago.stats!!.level120.firepower.shouldBe(270)
            atago.stats!!.level120.torpedo.shouldBe(245)
            atago.stats!!.level120.evasion.shouldBe(79)
            atago.stats!!.level120.speed.shouldBe(31)
            atago.stats!!.level120.antiAir.shouldBe(178)
            atago.stats!!.level120.aviation.shouldBe(0)
            atago.stats!!.level120.oil.shouldBe(12)
            atago.stats!!.level120.accuracy.shouldBe(134)
            atago.stats!!.level120.antiSub.shouldBe(0)

            atago.stats!!.level100.health.shouldBe(3818)
            atago.stats!!.level100.armor.shouldBe("Medium")
            atago.stats!!.level100.reload.shouldBe(152)
            atago.stats!!.level100.luck.shouldBe(48)
            atago.stats!!.level100.firepower.shouldBe(236)
            atago.stats!!.level100.torpedo.shouldBe(213)
            atago.stats!!.level100.evasion.shouldBe(33)
            atago.stats!!.level100.speed.shouldBe(31)
            atago.stats!!.level100.antiAir.shouldBe(155)
            atago.stats!!.level100.aviation.shouldBe(0)
            atago.stats!!.level100.oil.shouldBe(12)
            atago.stats!!.level100.accuracy.shouldBe(119)
            atago.stats!!.level100.antiSub.shouldBe(0)

            atago.stats!!.base.health.shouldBe(738)
            atago.stats!!.base.armor.shouldBe("Medium")
            atago.stats!!.base.reload.shouldBe(64)
            atago.stats!!.base.luck.shouldBe(48)
            atago.stats!!.base.firepower.shouldBe(50)
            atago.stats!!.base.torpedo.shouldBe(45)
            atago.stats!!.base.evasion.shouldBe(13)
            atago.stats!!.base.speed.shouldBe(31)
            atago.stats!!.base.antiAir.shouldBe(33)
            atago.stats!!.base.aviation.shouldBe(0)
            atago.stats!!.base.oil.shouldBe(4)
            atago.stats!!.base.accuracy.shouldBe(46)
            atago.stats!!.base.antiSub.shouldBe(0)

            atago.misc!!.artist.shouldBe("木shiyo")
            atago.misc!!.web!!.name.shouldBe("木shiyo")
            atago.misc!!.web!!.url.shouldBe("https://weibo.com/u/2481339344")
            atago.misc!!.pixiv!!.name.shouldBe("木shiyo")
            atago.misc!!.pixiv!!.url.shouldBe("https://www.pixiv.net/member.php?id=40222")
            atago.misc!!.twitter!!.name.shouldBe("木shiyo")
            atago.misc!!.twitter!!.url.shouldBe("https://twitter.com/kishiyo1943")
            atago.misc!!.voice.shouldBe("Ai Kayano")
        }
    }
}