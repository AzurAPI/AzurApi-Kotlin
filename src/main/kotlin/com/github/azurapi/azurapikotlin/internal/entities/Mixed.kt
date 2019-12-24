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
 * Names in different language
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
