package com.gemwallet.android.ext

import android.text.format.DateUtils
import com.wallet.core.primitives.Chain
import java.math.BigInteger

fun Chain.getReserveBalance(): BigInteger = when (this) {
    Chain.Xrp -> BigInteger.valueOf(10_000_000)
    else -> BigInteger.ZERO
}

fun Chain.eip1559Support() = when (this) {
    Chain.OpBNB,
    Chain.Optimism,
    Chain.Base,
    Chain.AvalancheC,
    Chain.SmartChain,
    Chain.Polygon,
    Chain.Fantom,
    Chain.Gnosis,
    Chain.Manta,
    Chain.Blast,
    Chain.ZkSync,
    Chain.Linea,
    Chain.Mantle,
    Chain.Celo,
    Chain.Ethereum -> true
    Chain.Bitcoin,
    Chain.Litecoin,
    Chain.Solana,
    Chain.Thorchain,
    Chain.Cosmos,
    Chain.Osmosis,
    Chain.Sei,
    Chain.Arbitrum,
    Chain.Ton,
    Chain.Tron,
    Chain.Doge,
    Chain.Aptos,
    Chain.Sui,
    Chain.Celestia,
    Chain.Injective,
    Chain.Noble,
    Chain.Near,
    Chain.Xrp -> false
}

fun Chain.Companion.findByString(value: String): Chain? {
    return Chain.entries.firstOrNull{ it.string == value}
}