/**
 * Generated by typeshare 1.9.2
 */

@file:NoLiveLiterals

package com.wallet.core.blockchain.ethereum.models

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.serialization.*

@Serializable
data class EthereumTransactionReciept (
	val status: String,
	val gasUsed: String,
	val effectiveGasPrice: String,
	val l1Fee: String? = null
)

@Serializable
data class EthereumFeeHistory (
	val reward: List<List<String>>,
	val baseFeePerGas: List<String>
)
