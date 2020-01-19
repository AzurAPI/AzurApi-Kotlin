package com.github.azurapi.azurapikotlin.internal.entities

import java.util.Date

/**
 * Version representation
 * @param apiVersion api version
 * @param lastUpdatedApi last time database has been reloaded
 * @param databaseVersion json version
 * @param lastUpdatedDatabase last time json has been refreshed
 */
data class Version(
    val apiVersion: String,
    val lastUpdatedApi: Date,
    val databaseVersion: Int,
    val lastUpdatedDatabase: Date
)