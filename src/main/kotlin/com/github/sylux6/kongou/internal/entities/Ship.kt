package com.github.sylux6.kongou.internal.entities

data class Stars (
        val stars: String,
        val value: Int
)

data class SkinInfo (
        val obtainedFrom: String,
        val live2D: Boolean
)

data class Skin (
        val image: String,
        val background: String,
        val name: String,
        val chibi: String,
        val info: SkinInfo
)

data class Name (
        val jp: String,
        val kr: String,
        val en: String,
        val cn: String
)

data class StatsDetails (
        val speed: String,
        val aviation: String,
        val health: String,
        val torpedo: String,
        val evasion: String,
        val luck: String,
        val armor: String,
        val reload: String,
        val antiAir: String,
        val oil: String,
        val accuracy: String,
        val antiSub: String,
        val firepower: String
)

data class Stats (
        val level120: StatsDetails,
        val level100: StatsDetails,
        val base: StatsDetails
)

data class Miscellaneous (
        val voice: String,
        val twitter: String,
        val artist: String,
        val web: String,
        val pixiv: String
)

data class Ship (
        val thumbnail: String,
        val buildTime: String,
        val stars: Stars,
        val skins: List<Skin>,
        val names: Name,
        val nationality: String,
        val stats: Stats,
        val wikiUrl: String,
        val id: String,
        val shipClass: String,
        val hullType: String,
        val misc: Miscellaneous
)

