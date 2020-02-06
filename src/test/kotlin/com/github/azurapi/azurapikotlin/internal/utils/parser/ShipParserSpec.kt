package com.github.azurapi.azurapikotlin.internal.utils.parser

import ch.tutteli.atrium.api.fluent.en_GB.isEmpty
import ch.tutteli.atrium.api.fluent.en_GB.notToBeNull
import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import org.json.JSONObject
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ShipParserSpec : Spek({
    describe("Ship parser") {
        it("should correctly parse Atago") {
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
            expect(atago.wikiUrl).toBe("https://azurlane.koumakan.jp/Atago")
            expect(atago.id).toBe("201")
            expect(atago.names.en).toBe("Atago")
            expect(atago.names.cn).toBe("犬")
            expect(atago.names.jp).toBe("愛宕")
            expect(atago.names.kr).toBe("아타고")
            expect(atago.shipClass).toBe("Takao")
            expect(atago.nationality).toBe("Sakura Empire")
            expect(atago.hullType).toBe("Heavy Cruiser")
            expect(atago.thumbnail).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/thumbnail.png")

            expect(atago.skins.size).toBe(5)
            expect(atago.skins[0].name).toBe("Default")
            expect(atago.skins[0].image).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/image.png")
            expect(atago.skins[0].background).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png")
            expect(atago.skins[0].chibi).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Default/chibi.png")
            expect(atago.skins[0].info).notToBeNull()
            expect(atago.skins[0].info!!.enClient).isEmpty()
            expect(atago.skins[0].info!!.cnClient).isEmpty()
            expect(atago.skins[0].info!!.jpClient).isEmpty()
            expect(atago.skins[0].info!!.cost).toBe(0)
            expect(atago.skins[0].info!!.obtainedFrom).toBe("Default")
            expect(atago.skins[0].info!!.isLive2D).toBe(false)
            expect(atago.skins[1].name).toBe("Oath")
            expect(atago.skins[1].image).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/image.png")
            expect(atago.skins[1].background).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/MainDayBG.png")
            expect(atago.skins[1].chibi).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Oath/chibi.png")
            expect(atago.skins[1].info).notToBeNull()
            expect(atago.skins[1].info!!.enClient).toBe("Lily-White Vow")
            expect(atago.skins[1].info!!.cnClient).toBe("白花的誓言")
            expect(atago.skins[1].info!!.jpClient).toBe("白き約束")
            expect(atago.skins[1].info!!.cost).toBe(0)
            expect(atago.skins[1].info!!.obtainedFrom).toBe("Oath")
            expect(atago.skins[1].info!!.isLive2D).toBe(false)

            expect(atago.skins[2].name).toBe("Summer March")
            expect(atago.skins[2].image).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/image.png")
            expect(atago.skins[2].background).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_106.png")
            expect(atago.skins[2].chibi).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Summer_March/chibi.png")
            expect(atago.skins[2].info).notToBeNull()
            expect(atago.skins[2].info!!.enClient).toBe("Summer March")
            expect(atago.skins[2].info!!.cnClient).toBe("盛夏进行曲")
            expect(atago.skins[2].info!!.jpClient).toBe("真夏の行進曲")
            expect(atago.skins[2].info!!.cost).toBe(700)
            expect(atago.skins[2].info!!.obtainedFrom).toBe("Skin Shop")
            expect(atago.skins[2].info!!.isLive2D).toBe(true)

            expect(atago.skins[3].name).toBe("Hallmarks of Winter")
            expect(atago.skins[3].image).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/image.png")
            expect(atago.skins[3].background).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_101.png")
            expect(atago.skins[3].chibi).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/Hallmarks_of_Winter/chibi.png")
            expect(atago.skins[3].info).notToBeNull()
            expect(atago.skins[3].info!!.enClient).toBe("Hallmarks of Winter")
            expect(atago.skins[3].info!!.cnClient).toBe("冬季风物诗")
            expect(atago.skins[3].info!!.jpClient).toBe("冬の風物詩")
            expect(atago.skins[3].info!!.cost).toBe(780)
            expect(atago.skins[3].info!!.obtainedFrom).toBe("Skin Shop")
            expect(atago.skins[3].info!!.isLive2D).toBe(false)

            expect(atago.skins[4].name).toBe("School Traumerei")
            expect(atago.skins[4].image).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/image.png")
            expect(atago.skins[4].background).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/backgrounds/Skin_BG_103.png")
            expect(atago.skins[4].chibi).toBe("https://raw.githubusercontent.com/AzurAPI/azurapi-js-setup/master/images/skins/201/School_Traumerei/chibi.png")
            expect(atago.skins[4].info).notToBeNull()
            expect(atago.skins[4].info!!.enClient).toBe("School Traumerei")
            expect(atago.skins[4].info!!.cnClient).toBe("学园幻想曲")
            expect(atago.skins[4].info!!.jpClient).toBe("学園トロイメライ")
            expect(atago.skins[4].info!!.cost).toBe(880)
            expect(atago.skins[4].info!!.obtainedFrom).toBe("Skin Shop")
            expect(atago.skins[4].info!!.isLive2D).toBe(false)

            expect(atago.construction!!.constructionTime).toBe("02:05:00")
            expect(atago.construction!!.light).toBe(false)
            expect(atago.construction!!.heavy).toBe(true)
            expect(atago.construction!!.aviation).toBe(true)
            expect(atago.construction!!.limited).toBe(false)
            expect(atago.construction!!.exchange).toBe(false)
            expect(atago.rarity).toBe("Super Rare")

            expect(atago.stars!!.stars).toBe("★★★☆☆☆")
            expect(atago.stars!!.value).toBe(3)

            expect(atago.stats!!.level120.health).toBe(4295)
            expect(atago.stats!!.level120.armor).toBe("Medium")
            expect(atago.stats!!.level120.reload).toBe(175)
            expect(atago.stats!!.level120.luck).toBe(48)
            expect(atago.stats!!.level120.firepower).toBe(270)
            expect(atago.stats!!.level120.torpedo).toBe(245)
            expect(atago.stats!!.level120.evasion).toBe(79)
            expect(atago.stats!!.level120.speed).toBe(31)
            expect(atago.stats!!.level120.antiAir).toBe(178)
            expect(atago.stats!!.level120.aviation).toBe(0)
            expect(atago.stats!!.level120.oil).toBe(12)
            expect(atago.stats!!.level120.accuracy).toBe(134)
            expect(atago.stats!!.level120.antiSub).toBe(0)

            expect(atago.stats!!.level100.health).toBe(3818)
            expect(atago.stats!!.level100.armor).toBe("Medium")
            expect(atago.stats!!.level100.reload).toBe(152)
            expect(atago.stats!!.level100.luck).toBe(48)
            expect(atago.stats!!.level100.firepower).toBe(236)
            expect(atago.stats!!.level100.torpedo).toBe(213)
            expect(atago.stats!!.level100.evasion).toBe(33)
            expect(atago.stats!!.level100.speed).toBe(31)
            expect(atago.stats!!.level100.antiAir).toBe(155)
            expect(atago.stats!!.level100.aviation).toBe(0)
            expect(atago.stats!!.level100.oil).toBe(12)
            expect(atago.stats!!.level100.accuracy).toBe(119)
            expect(atago.stats!!.level100.antiSub).toBe(0)

            expect(atago.stats!!.base.health).toBe(738)
            expect(atago.stats!!.base.armor).toBe("Medium")
            expect(atago.stats!!.base.reload).toBe(64)
            expect(atago.stats!!.base.luck).toBe(48)
            expect(atago.stats!!.base.firepower).toBe(50)
            expect(atago.stats!!.base.torpedo).toBe(45)
            expect(atago.stats!!.base.evasion).toBe(13)
            expect(atago.stats!!.base.speed).toBe(31)
            expect(atago.stats!!.base.antiAir).toBe(33)
            expect(atago.stats!!.base.aviation).toBe(0)
            expect(atago.stats!!.base.oil).toBe(4)
            expect(atago.stats!!.base.accuracy).toBe(46)
            expect(atago.stats!!.base.antiSub).toBe(0)

            expect(atago.misc!!.artist).toBe("木shiyo")
            expect(atago.misc!!.web!!.name).toBe("木shiyo")
            expect(atago.misc!!.web!!.url).toBe("https://weibo.com/u/2481339344")
            expect(atago.misc!!.pixiv!!.name).toBe("木shiyo")
            expect(atago.misc!!.pixiv!!.url).toBe("https://www.pixiv.net/member.php?id=40222")
            expect(atago.misc!!.twitter!!.name).toBe("木shiyo")
            expect(atago.misc!!.twitter!!.url).toBe("https://twitter.com/kishiyo1943")
            expect(atago.misc!!.voice!!.name).toBe("Ai Kayano")
            expect(atago.misc!!.voice!!.url).toBe("https://en.wikipedia.org/wiki/Ai_Kayano")
        }
    }
})
