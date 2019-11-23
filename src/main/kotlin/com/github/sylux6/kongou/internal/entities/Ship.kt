package com.github.sylux6.kongou.internal.entities

data class BaseShip (
    val id: String,
    val name: String,
    val rarity: String,
    val type: String,
    val affiliation: String,
    val href: String
)

data class Name (
    val en: String,
    val jp: String,
    val cn: String,
    val kr: String
)

data class Skin (
    val title: String,
    val image: String,
    val chibi: String
)

