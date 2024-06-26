/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.primitives

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
enum class BitcoinChain(val string: String) {
	@SerialName("bitcoin")
	Bitcoin("bitcoin"),
	@SerialName("litecoin")
	Litecoin("litecoin"),
	@SerialName("doge")
	Doge("doge"),
}

