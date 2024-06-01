/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.primitives

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
enum class StakeChain(val string: String) {
	@SerialName("cosmos")
	Cosmos("cosmos"),
	@SerialName("osmosis")
	Osmosis("osmosis"),
	@SerialName("injective")
	Injective("injective"),
	@SerialName("sei")
	Sei("sei"),
	@SerialName("celestia")
	Celestia("celestia"),
	@SerialName("solana")
	Solana("solana"),
	@SerialName("sui")
	Sui("sui"),
	@SerialName("smartchain")
	SmartChain("smartchain"),
}
