/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.primitives

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
data class Device (
	val id: String,
	val platform: Platform,
	val token: String,
	val locale: String,
	val version: String,
	val currency: String,
	val isPushEnabled: Boolean,
	val subscriptionsVersion: Int
)
