/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.primitives

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
data class ConfigAppVersion (
	val production: String,
	val beta: String,
	val alpha: String
)

@Serializable
data class ConfigIOSApp (
	val version: ConfigAppVersion
)

@Serializable
data class ConfigAndroidApp (
	val version: ConfigAppVersion
)

@Serializable
data class ConfigApp (
	val ios: ConfigIOSApp,
	val android: ConfigAndroidApp
)

@Serializable
data class ConfigVersions (
	val nodes: Int,
	val fiatAssets: Int,
	val swapAssets: Int
)

@Serializable
data class ConfigResponse (
	val app: ConfigApp,
	val versions: ConfigVersions
)
