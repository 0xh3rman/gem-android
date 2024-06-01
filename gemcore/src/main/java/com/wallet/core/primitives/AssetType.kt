/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.primitives

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
enum class AssetType(val string: String) {
	@SerialName("NATIVE")
	NATIVE("NATIVE"),
	@SerialName("ERC20")
	ERC20("ERC20"),
	@SerialName("BEP20")
	BEP20("BEP20"),
	@SerialName("SPL")
	SPL("SPL"),
	@SerialName("TRC20")
	TRC20("TRC20"),
	@SerialName("TOKEN")
	TOKEN("TOKEN"),
	@SerialName("IBC")
	IBC("IBC"),
	@SerialName("JETTON")
	JETTON("JETTON"),
	@SerialName("SYNTH")
	SYNTH("SYNTH"),
}

@Serializable
enum class AssetSubtype(val string: String) {
	@SerialName("NATIVE")
	NATIVE("NATIVE"),
	@SerialName("TOKEN")
	TOKEN("TOKEN"),
}
