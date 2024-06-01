/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.blockchain.cosmos.models

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
data class CosmosBroadcastResult (
	val txhash: String,
	val code: Int,
	val raw_log: String
)

@Serializable
data class CosmosBroadcastResponse (
	val tx_response: CosmosBroadcastResult
)

@Serializable
data class CosmosTransactionDataResponse (
	val txhash: String,
	val code: Int
)

@Serializable
data class CosmosTransactionResponse (
	val tx_response: CosmosTransactionDataResponse
)
