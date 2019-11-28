package com.github.sylux6.azurapikotlin.database

import com.github.kittinunf.fuel.httpGet
import com.github.sylux6.azurapikotlin.utils.ShipParser
import org.json.JSONObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TakaoTests {

    @Test
    fun `should get remote json`() {
        val (_, response, _) = TakaoInfo.JSON_SOURCE
            .httpGet()
            .response()
        Assertions.assertEquals(response.statusCode, 200)
    }

    @Test
    fun `should init database`() {
        Assertions.assertFalse(Takao.shipsById.isEmpty())
        Assertions.assertFalse(Takao.shipsByName.isEmpty())
    }

    @Test
    fun `should correctly parse Atago`() {
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

        Assertions.assertEquals(atago.wikiUrl, "https://azurlane.koumakan.jp/Atago")
        Assertions.assertEquals(atago.id, "201")
        Assertions.assertEquals(atago.names.en, "Atago")
        Assertions.assertEquals(atago.names.cn, "爱宕")
        Assertions.assertEquals(atago.names.jp, "愛宕")
        Assertions.assertEquals(atago.names.kr, "아타고")
        Assertions.assertEquals(atago.shipClass, "Takao")
        Assertions.assertEquals(atago.nationality, "Sakura Empire")
        Assertions.assertEquals(atago.hullType, "Heavy Cruiser")
        Assertions.assertEquals(atago.thumbnail, "https://azurlane.koumakan.jp/w/images/0/0c/AtagoIcon.png")

        Assertions.assertEquals(atago.skins.size, 5)
        Assertions.assertEquals(atago.skins[0].name, "Default")
        Assertions.assertEquals(atago.skins[0].image, "https://azurlane.koumakan.jp/w/images/thumb/6/65/Atago.png/642px-Atago.png")
        Assertions.assertEquals(atago.skins[0].background, "https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png")
        Assertions.assertEquals(atago.skins[0].chibi, "https://azurlane.koumakan.jp/w/images/3/33/AtagoChibi.png")
        Assertions.assertNotNull(atago.skins[0].info)
        Assertions.assertEquals(atago.skins[0].info!!.enClient, "")
        Assertions.assertEquals(atago.skins[0].info!!.cnClient, "")
        Assertions.assertEquals(atago.skins[0].info!!.jpClient, "")
        Assertions.assertEquals(atago.skins[0].info!!.cost, 0)
        Assertions.assertEquals(atago.skins[0].info!!.obtainedFrom, "Default")
        Assertions.assertFalse(atago.skins[0].info!!.isLive2D)
        Assertions.assertEquals(atago.skins[1].name, "Oath")
        Assertions.assertEquals(atago.skins[1].image, "https://azurlane.koumakan.jp/w/images/thumb/5/58/AtagoWedding.png/668px-AtagoWedding.png")
        Assertions.assertEquals(atago.skins[1].background, "https://azurlane.koumakan.jp/w/images/3/3a/MainDayBG.png")
        Assertions.assertEquals(atago.skins[1].chibi, "https://azurlane.koumakan.jp/w/images/1/1e/AtagoWeddingChibi.png")
        Assertions.assertNotNull(atago.skins[1].info)
        Assertions.assertEquals(atago.skins[1].info!!.enClient, "Lily-White Vow")
        Assertions.assertEquals(atago.skins[1].info!!.cnClient, "")
        Assertions.assertEquals(atago.skins[1].info!!.jpClient, "White Promise")
        Assertions.assertEquals(atago.skins[1].info!!.cost, 0)
        Assertions.assertEquals(atago.skins[1].info!!.obtainedFrom, "Oath")
        Assertions.assertFalse(atago.skins[1].info!!.isLive2D)

        Assertions.assertEquals(atago.skins[2].name, "Summer March")
        Assertions.assertEquals(atago.skins[2].image, "https://azurlane.koumakan.jp/w/images/thumb/3/36/AtagoSummer.png/352px-AtagoSummer.png")
        Assertions.assertEquals(atago.skins[2].background, "https://azurlane.koumakan.jp/w/images/1/1c/Skin_BG_106.png")
        Assertions.assertEquals(atago.skins[2].chibi, "https://azurlane.koumakan.jp/w/images/0/01/AtagoSummerChibi.png")
        Assertions.assertNotNull(atago.skins[2].info)
        Assertions.assertEquals(atago.skins[2].info!!.enClient, "Summer March")
        Assertions.assertEquals(atago.skins[2].info!!.cnClient, "")
        Assertions.assertEquals(atago.skins[2].info!!.jpClient, "Midsummer March")
        Assertions.assertEquals(atago.skins[2].info!!.cost, 700)
        Assertions.assertEquals(atago.skins[2].info!!.obtainedFrom, "Skin Shop")
        Assertions.assertTrue(atago.skins[2].info!!.isLive2D)

        Assertions.assertEquals(atago.skins[3].name, "Hallmarks of Winter")
        Assertions.assertEquals(atago.skins[3].image, "https://azurlane.koumakan.jp/w/images/thumb/4/4e/AtagoNew_Year.png/462px-AtagoNew_Year.png")
        Assertions.assertEquals(atago.skins[3].background, "https://azurlane.koumakan.jp/w/images/5/5b/Skin_BG_101.png")
        Assertions.assertEquals(atago.skins[3].chibi, "https://azurlane.koumakan.jp/w/images/8/8b/AtagoNew_YearChibi.png")
        Assertions.assertNotNull(atago.skins[3].info)
        Assertions.assertEquals(atago.skins[3].info!!.enClient, "Hallmarks of Winter")
        Assertions.assertEquals(atago.skins[3].info!!.cnClient, "")
        Assertions.assertEquals(atago.skins[3].info!!.jpClient, "Features of Winter")
        Assertions.assertEquals(atago.skins[3].info!!.cost, 780)
        Assertions.assertEquals(atago.skins[3].info!!.obtainedFrom, "Skin Shop")
        Assertions.assertFalse(atago.skins[3].info!!.isLive2D)

        Assertions.assertEquals(atago.skins[4].name, "School Traumerei")
        Assertions.assertEquals(atago.skins[4].image, "https://azurlane.koumakan.jp/w/images/thumb/9/96/AtagoSchool.png/448px-AtagoSchool.png")
        Assertions.assertEquals(atago.skins[4].background, "https://azurlane.koumakan.jp/w/images/6/64/Skin_BG_103.png")
        Assertions.assertEquals(atago.skins[4].chibi, "https://azurlane.koumakan.jp/w/images/4/49/AtagoSchoolChibi.png")
        Assertions.assertNotNull(atago.skins[4].info)
        Assertions.assertEquals(atago.skins[4].info!!.enClient, "School Traumerei")
        Assertions.assertEquals(atago.skins[4].info!!.cnClient, "")
        Assertions.assertEquals(atago.skins[4].info!!.jpClient, "School Traumerei")
        Assertions.assertEquals(atago.skins[4].info!!.cost, 880)
        Assertions.assertEquals(atago.skins[4].info!!.obtainedFrom, "Skin Shop")
        Assertions.assertFalse(atago.skins[4].info!!.isLive2D)

        Assertions.assertEquals(atago.buildTime, "02:05:00")
        Assertions.assertEquals(atago.rarity, "Super Rare")

        Assertions.assertEquals(atago.stars!!.stars, "★★★☆☆☆")
        Assertions.assertEquals(atago.stars!!.value, 3)

        Assertions.assertEquals(atago.stats!!.level120.health, 4295)
        Assertions.assertEquals(atago.stats!!.level120.armor, "Medium")
        Assertions.assertEquals(atago.stats!!.level120.reload, 175)
        Assertions.assertEquals(atago.stats!!.level120.luck, 48)
        Assertions.assertEquals(atago.stats!!.level120.firepower, 270)
        Assertions.assertEquals(atago.stats!!.level120.torpedo, 245)
        Assertions.assertEquals(atago.stats!!.level120.evasion, 79)
        Assertions.assertEquals(atago.stats!!.level120.speed, 31)
        Assertions.assertEquals(atago.stats!!.level120.antiAir, 178)
        Assertions.assertEquals(atago.stats!!.level120.aviation, 0)
        Assertions.assertEquals(atago.stats!!.level120.oil, 12)
        Assertions.assertEquals(atago.stats!!.level120.accuracy, 134)
        Assertions.assertEquals(atago.stats!!.level120.antiSub, 0)

        Assertions.assertEquals(atago.stats!!.level100.health, 3818)
        Assertions.assertEquals(atago.stats!!.level100.armor, "Medium")
        Assertions.assertEquals(atago.stats!!.level100.reload, 152)
        Assertions.assertEquals(atago.stats!!.level100.luck, 48)
        Assertions.assertEquals(atago.stats!!.level100.firepower, 236)
        Assertions.assertEquals(atago.stats!!.level100.torpedo, 213)
        Assertions.assertEquals(atago.stats!!.level100.evasion, 33)
        Assertions.assertEquals(atago.stats!!.level100.speed, 31)
        Assertions.assertEquals(atago.stats!!.level100.antiAir, 155)
        Assertions.assertEquals(atago.stats!!.level100.aviation, 0)
        Assertions.assertEquals(atago.stats!!.level100.oil, 12)
        Assertions.assertEquals(atago.stats!!.level100.accuracy, 119)
        Assertions.assertEquals(atago.stats!!.level100.antiSub, 0)

        Assertions.assertEquals(atago.stats!!.base.health, 738)
        Assertions.assertEquals(atago.stats!!.base.armor, "Medium")
        Assertions.assertEquals(atago.stats!!.base.reload, 64)
        Assertions.assertEquals(atago.stats!!.base.luck, 48)
        Assertions.assertEquals(atago.stats!!.base.firepower, 50)
        Assertions.assertEquals(atago.stats!!.base.torpedo, 45)
        Assertions.assertEquals(atago.stats!!.base.evasion, 13)
        Assertions.assertEquals(atago.stats!!.base.speed, 31)
        Assertions.assertEquals(atago.stats!!.base.antiAir, 33)
        Assertions.assertEquals(atago.stats!!.base.aviation, 0)
        Assertions.assertEquals(atago.stats!!.base.oil, 4)
        Assertions.assertEquals(atago.stats!!.base.accuracy, 46)
        Assertions.assertEquals(atago.stats!!.base.antiSub, 0)

        Assertions.assertEquals(atago.misc!!.artist, "木shiyo")
        Assertions.assertEquals(atago.misc!!.web!!.name, "木shiyo")
        Assertions.assertEquals(atago.misc!!.web!!.url, "https://weibo.com/u/2481339344")
        Assertions.assertEquals(atago.misc!!.pixiv!!.name, "木shiyo")
        Assertions.assertEquals(atago.misc!!.pixiv!!.url, "https://www.pixiv.net/member.php?id=40222")
        Assertions.assertEquals(atago.misc!!.twitter!!.name, "木shiyo")
        Assertions.assertEquals(atago.misc!!.twitter!!.url, "https://twitter.com/kishiyo1943")
        Assertions.assertEquals(atago.misc!!.voice, "Ai Kayano")
    }
}