package com.github.azurapi.azurapikotlin.internal.entities

import java.util.Date

/**
 * Version representation of remote data
 */
data class RemoteVersion(
    val versionNumber: Int,
    val lastDataRefreshDate: Date
)

/**
 * Version representation
 * @param apiVersion api version
 * @param lastUpdatedDate last time database has been reloaded
 * @param remoteVersion remote json version by entity
 */
data class Version(
    val apiVersion: String,
    val lastUpdatedDate: Date,
    val remoteVersion: Map<String, RemoteVersion>
)
