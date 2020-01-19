package com.github.azurapi.azurapikotlin.internal.entities

/**
 * Stars of a ship
 * @param stars
 * @param value
 */
data class Stars(
    val stars: String,
    val value: Int
)

/**
 * Details about a skin of a ship
 * @param enClient
 * @param cnClient
 * @param jpClient
 * @param obtainedFrom
 * @param cost
 * @param isLive2D
 */
data class SkinInfo(
    val enClient: String,
    val cnClient: String,
    val jpClient: String,
    val obtainedFrom: String?,
    val cost: Int,
    val isLive2D: Boolean
)

/**
 * Skin of a ship
 * @param image
 * @param background
 * @param name
 * @param chibi
 * @param info
 */
data class Skin(
    val image: String,
    val background: String,
    val name: String,
    val chibi: String,
    val info: SkinInfo?
)

/**
 * Names of a ship in different language
 * @param jp japanese name
 * @param kr korean name
 * @param en english name
 * @param cn chinese name
 */
data class Name(
    val jp: String,
    val kr: String,
    val en: String,
    val cn: String
)

/**
 * Stats details
 * @param speed
 * @param aviation
 * @param health
 * @param torpedo
 * @param evasion
 * @param luck
 * @param armor
 * @param reload
 * @param antiAir
 * @param oil
 * @param accuracy
 * @param antiSub
 * @param firepower
 */
data class StatsDetails(
    val speed: Int,
    val aviation: Int,
    val health: Int,
    val torpedo: Int,
    val evasion: Int,
    val luck: Int,
    val armor: String,
    val reload: Int,
    val antiAir: Int,
    val oil: Int,
    val accuracy: Int,
    val antiSub: Int,
    val firepower: Int
)

/**
 * Base stats and stats of a ship at level 120, 100
 * @param level120
 * @param level100
 * @param base
 */
data class Stats(
    val level120: StatsDetails,
    val level100: StatsDetails,
    val base: StatsDetails
)

/**
 * Url
 * @param name
 * @param url
 */
data class Url(
    val name: String,
    val url: String
)

/**
 * Construction info of a ship
 * @param constructionTime
 * @param light
 * @param heavy
 * @param aviation
 * @param limited
 * @param exchange
 */
data class ShipConstruction(
    val constructionTime: String,
    val light: Boolean,
    val heavy: Boolean,
    val aviation: Boolean,
    val limited: Boolean,
    val exchange: Boolean
)

/**
 * Miscellaneous info of a ship
 * @param voice
 * @param twitter
 * @param artist
 * @param web
 * @param pixiv
 */
data class Miscellaneous(
    val voice: Url?,
    val twitter: Url?,
    val artist: String?,
    val web: Url?,
    val pixiv: Url?
)

/**
 * Class representation of a ship
 * @param thumbnail
 * @param stars
 * @param skins
 * @param names
 * @param nationality
 * @param rarity
 * @param stats
 * @param wikiUrl
 * @param id
 * @param shipClass
 * @param hullType
 * @param construction
 * @param misc
 */
data class Ship(
    val wikiUrl: String,
    val id: String,
    val names: Name,
    val shipClass: String,
    val nationality: String,
    val hullType: String,
    val thumbnail: String,
    val skins: List<Skin>,
    val rarity: String,
    val stars: Stars?,
    val stats: Stats?,
    // No construction info for unreleased ships
    val construction: ShipConstruction?,
    val misc: Miscellaneous?
)

