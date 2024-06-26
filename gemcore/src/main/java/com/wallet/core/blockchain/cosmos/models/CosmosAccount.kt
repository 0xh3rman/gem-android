/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.blockchain.cosmos.models

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
data class CosmosAccount (
	val account_number: String,
	val sequence: String
)

@Serializable
data class CosmosAccountResponse<T> (
	val account: T
)

@Serializable
data class CosmosInjectiveAccount (
	val base_account: CosmosAccount
)

