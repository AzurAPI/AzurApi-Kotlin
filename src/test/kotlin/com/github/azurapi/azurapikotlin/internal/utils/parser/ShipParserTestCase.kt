package com.github.azurapi.azurapikotlin.internal.utils.parser

import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.string.shouldBeEmpty
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.json.JSONObject

class ShipParserTestCase : StringSpec() {

    init {
        "it should correctly parse Atago" {
            val json = JSONObject(
                """
            {
                "201": {
                    "wikiUrl": "https://azurlane.koumakan.jp/Atago",
                    "id": "201",
                    "names": {
                        "en": "Atago",
                        "code": "IJN Atago",
                        "cn": "犬",
                        "jp": "愛宕",
                        "kr": "아타고"
                    },
                    "class": "Takao",
                    "nationality": "Sakura Empire",
                    "hullType": "Heavy Cruiser",
                    "thumbnail": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/thumbnail.png",
                    "rarity": "Super Rare",
                    "stars": {
                        "stars": "★★★☆☆☆",
                        "value": 3
                    },
                    "stats": {
                        "level120": {
                            "health": "4295",
                            "armor": "Medium",
                            "reload": "175",
                            "luck": "48",
                            "firepower": "270",
                            "torpedo": "245",
                            "evasion": "79",
                            "speed": "31",
                            "antiair": "178",
                            "aviation": "0",
                            "oilConsumption": "12",
                            "accuracy": "134",
                            "antisubmarineWarfare": "0"
                        },
                        "level100": {
                            "health": "3818",
                            "armor": "Medium",
                            "reload": "152",
                            "luck": "48",
                            "firepower": "236",
                            "torpedo": "213",
                            "evasion": "33",
                            "speed": "31",
                            "antiair": "155",
                            "aviation": "0",
                            "oilConsumption": "12",
                            "accuracy": "119",
                            "antisubmarineWarfare": "0"
                        },
                        "baseStats": {
                            "health": "738",
                            "armor": "Medium",
                            "reload": "64",
                            "luck": "48",
                            "firepower": "50",
                            "torpedo": "45",
                            "evasion": "13",
                            "speed": "31",
                            "antiair": "33",
                            "aviation": "0",
                            "oilConsumption": "4",
                            "accuracy": "46",
                            "antisubmarineWarfare": "0"
                        }
                    },
                    "slots": {
                        "1": {
                            "type": "CA Guns",
                            "minEfficiency": 130,
                            "maxEfficiency": 135
                        },
                        "2": {
                            "type": "Torpedoes",
                            "minEfficiency": 145,
                            "maxEfficiency": 170
                        },
                        "3": {
                            "type": "Anti-Air Guns",
                            "minEfficiency": 100,
                            "maxEfficiency": 100
                        }
                    },
                    "enhanceValue": {
                        "firepower": 28,
                        "torpedo": 15,
                        "aviation": 0,
                        "reload": 12
                    },
                    "scrapValue": {
                        "coin": 9,
                        "oil": 3,
                        "medal": 10
                    },
                    "skills": [
                        {
                            "icon": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skills/arsonist.png",
                            "names": {
                                "en": "Arsonist",
                                "cn": "纵火狂魔",
                                "jp": "爆炎開放"
                            },
                            "description": "Increases damage dealt with HE ammo by 5% (15%), Burn damage by 20% (50%), and chance to ignite with HE ammo by 4.5% (12%).",
                            "color": "pink"
                        },
                        {
                            "icon": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skills/double_torpedo.png",
                            "names": {
                                "en": "Double Torpedo",
                                "cn": "鱼雷连射",
                                "jp": "次発装填"
                            },
                            "description": "When launching a wave of torpedoes: 15% (30%) chance to launch another wave.",
                            "color": "pink"
                        },
                        {
                            "icon": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skills/all_out_assault.png",
                            "names": {
                                "en": "All Out Assault",
                                "cn": "全弹发射",
                                "jp": "全弾発射-高雄型"
                            },
                            "description": "Every 9 (6) shots from the main battery, triggers Full Barrage - Takao Class I (II).",
                            "color": "pink"
                        }
                    ],
                    "limitBreaks": [
                        [
                            "Gains Full Barrage I",
                            "Main Gun Efficiency +5%"
                        ],
                        [
                            "Max Torpedo Capacity +1",
                            "Pre-Loaded Torpedo +1",
                            "Torpedo Efficiency +10%"
                        ],
                        [
                            "Upgrades Full Barrage I→II",
                            "Torpedo Efficiency +15%"
                        ]
                    ],
                    "fleetTech": {
                        "statsBonus": {
                            "collection": {
                                "applicable": [
                                    "Heavy cruiser",
                                    "Large cruiser",
                                    "Monitor"
                                ],
                                "stat": "Health",
                                "bonus": "+1"
                            },
                            "maxLevel": {
                                "applicable": [
                                    "Heavy cruiser",
                                    "Large cruiser",
                                    "Monitor"
                                ],
                                "stat": "Torpedo",
                                "bonus": "+1"
                            }
                        },
                        "techPoints": {
                            "collection": 14,
                            "maxLimitBreak": 28,
                            "maxLevel": 21,
                            "total": 63
                        }
                    },
                    "construction": {
                        "constructionTime": "02:05:00",
                        "availableIn": {
                            "light": false,
                            "heavy": true,
                            "aviation": true,
                            "limited": false,
                            "exchange": false
                        }
                    },
                    "gallery": [
                        {
                            "description": "Loading Screen featuring Takao, Atago, Akagi, and Kaga in a winter setting",
                            "url": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/gallery/Bg_takao_1.png"
                        },
                        {
                            "description": "Monarch, Atago, Takao, and Emile Bertin in the hot springs",
                            "url": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/gallery/Bg_bath.png"
                        },
                        {
                            "description": "Loading Screen featuring Atago during valentines",
                            "url": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/gallery/Bg_valentines_3.png"
                        },
                        {
                            "description": "Takao and Atago after making chocolates",
                            "url": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/gallery/Bg_valentines_5.png"
                        },
                        {
                            "description": "Taihou, Formidable, Bismarck, Roon, Tirpitz, Kaga, Amagi, Cleveland, Atago and Essex during Halloween",
                            "url": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/gallery/Bg_2019.10.31_5.png"
                        }
                    ],
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
                        "voice": {
                            "name": "Ai Kayano",
                            "url": "https://en.wikipedia.org/wiki/Ai_Kayano"
                        }
                    },
                    "skins": [
                        {
                            "name": "Default",
                            "image": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/image.png",
                            "background": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png",
                            "chibi": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/chibi.png",
                            "info": {
                                "obtainedFrom": "Default",
                                "live2dModel": false
                            }
                        },
                        {
                            "name": "Oath",
                            "image": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/image.png",
                            "background": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png",
                            "chibi": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/chibi.png",
                            "info": {
                                "enClient": "Lily-White Vow",
                                "cnClient": "白花的誓言",
                                "jpClient": "白き約束",
                                "obtainedFrom": "Oath",
                                "live2dModel": false
                            }
                        },
                        {
                            "name": "Summer March",
                            "image": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/image.png",
                            "background": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_106.png",
                            "chibi": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/chibi.png",
                            "info": {
                                "enClient": "Summer March",
                                "cnClient": "盛夏进行曲",
                                "jpClient": "真夏の行進曲",
                                "obtainedFrom": "Skin Shop",
                                "cost": 700,
                                "live2dModel": true
                            }
                        },
                        {
                            "name": "Hallmarks of Winter",
                            "image": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/image.png",
                            "background": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_101.png",
                            "chibi": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/chibi.png",
                            "info": {
                                "enClient": "Hallmarks of Winter",
                                "cnClient": "冬季风物诗",
                                "jpClient": "冬の風物詩",
                                "obtainedFrom": "Skin Shop",
                                "cost": 780,
                                "live2dModel": false
                            }
                        },
                        {
                            "name": "School Traumerei",
                            "image": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/image.png",
                            "background": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_103.png",
                            "chibi": "https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/chibi.png",
                            "info": {
                                "enClient": "School Traumerei",
                                "cnClient": "学园幻想曲",
                                "jpClient": "学園トロイメライ",
                                "obtainedFrom": "Skin Shop",
                                "cost": 880,
                                "live2dModel": false
                            }
                        }
                    ]
                }
            }
        """.trimIndent()
            )
            val atago = jsonToShip(
                json.optJSONObject("201"), "201"
            )

            atago.wikiUrl.shouldBe("https://azurlane.koumakan.jp/Atago")
            atago.id.shouldBe("201")
            atago.names.en.shouldBe("Atago")
            atago.names.cn.shouldBe("犬")
            atago.names.jp.shouldBe("愛宕")
            atago.names.kr.shouldBe("아타고")
            atago.shipClass.shouldBe("Takao")
            atago.nationality.shouldBe("Sakura Empire")
            atago.hullType.shouldBe("Heavy Cruiser")
            atago.thumbnail.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/thumbnail.png")

            atago.skins.shouldHaveSize(5)
            atago.skins[0].name.shouldBe("Default")
            atago.skins[0].image.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/image.png")
            atago.skins[0].background.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png")
            atago.skins[0].chibi.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/chibi.png")
            atago.skins[0].info.shouldNotBeNull()
            atago.skins[0].info!!.enClient.shouldBeEmpty()
            atago.skins[0].info!!.cnClient.shouldBeEmpty()
            atago.skins[0].info!!.jpClient.shouldBeEmpty()
            atago.skins[0].info!!.cost.shouldBe(0)
            atago.skins[0].info!!.obtainedFrom.shouldBe("Default")
            atago.skins[0].info!!.isLive2D.shouldBeFalse()
            atago.skins[1].name.shouldBe("Oath")
            atago.skins[1].image.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/image.png")
            atago.skins[1].background.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png")
            atago.skins[1].chibi.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/chibi.png")
            atago.skins[1].info.shouldNotBeNull()
            atago.skins[1].info!!.enClient.shouldBe("Lily-White Vow")
            atago.skins[1].info!!.cnClient.shouldBe("白花的誓言")
            atago.skins[1].info!!.jpClient.shouldBe("白き約束")
            atago.skins[1].info!!.cost.shouldBe(0)
            atago.skins[1].info!!.obtainedFrom.shouldBe("Oath")
            atago.skins[1].info!!.isLive2D.shouldBeFalse()

            atago.skins[2].name.shouldBe("Summer March")
            atago.skins[2].image.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/image.png")
            atago.skins[2].background.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_106.png")
            atago.skins[2].chibi.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/chibi.png")
            atago.skins[2].info.shouldNotBeNull()
            atago.skins[2].info!!.enClient.shouldBe("Summer March")
            atago.skins[2].info!!.cnClient.shouldBe("盛夏进行曲")
            atago.skins[2].info!!.jpClient.shouldBe("真夏の行進曲")
            atago.skins[2].info!!.cost.shouldBe(700)
            atago.skins[2].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[2].info!!.isLive2D.shouldBeTrue()

            atago.skins[3].name.shouldBe("Hallmarks of Winter")
            atago.skins[3].image.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/image.png")
            atago.skins[3].background.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_101.png")
            atago.skins[3].chibi.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/chibi.png")
            atago.skins[3].info.shouldNotBeNull()
            atago.skins[3].info!!.enClient.shouldBe("Hallmarks of Winter")
            atago.skins[3].info!!.cnClient.shouldBe("冬季风物诗")
            atago.skins[3].info!!.jpClient.shouldBe("冬の風物詩")
            atago.skins[3].info!!.cost.shouldBe(780)
            atago.skins[3].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[3].info!!.isLive2D.shouldBeFalse()

            atago.skins[4].name.shouldBe("School Traumerei")
            atago.skins[4].image.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/image.png")
            atago.skins[4].background.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_103.png")
            atago.skins[4].chibi.shouldBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/chibi.png")
            atago.skins[4].info.shouldNotBeNull()
            atago.skins[4].info!!.enClient.shouldBe("School Traumerei")
            atago.skins[4].info!!.cnClient.shouldBe("学园幻想曲")
            atago.skins[4].info!!.jpClient.shouldBe("学園トロイメライ")
            atago.skins[4].info!!.cost.shouldBe(880)
            atago.skins[4].info!!.obtainedFrom.shouldBe("Skin Shop")
            atago.skins[4].info!!.isLive2D.shouldBeFalse()

            atago.construction!!.constructionTime.shouldBe("02:05:00")
            atago.construction!!.light.shouldBeFalse()
            atago.construction!!.heavy.shouldBeTrue()
            atago.construction!!.aviation.shouldBeTrue()
            atago.construction!!.limited.shouldBeFalse()
            atago.construction!!.exchange.shouldBeFalse()
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
            atago.misc!!.voice!!.name.shouldBe("Ai Kayano")
            atago.misc!!.voice!!.url.shouldBe("https://en.wikipedia.org/wiki/Ai_Kayano")
        }
    }
}