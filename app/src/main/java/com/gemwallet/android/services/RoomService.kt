package com.gemwallet.android.services

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gemwallet.android.data.asset.AssetRoom
import com.gemwallet.android.data.asset.AssetsDao
import com.gemwallet.android.data.asset.BalanceRoom
import com.gemwallet.android.data.asset.BalancesDao
import com.gemwallet.android.data.asset.PriceRoom
import com.gemwallet.android.data.asset.PricesDao
import com.gemwallet.android.data.bridge.ConnectionsDao
import com.gemwallet.android.data.bridge.RoomConnection
import com.gemwallet.android.data.stake.RoomDelegationBase
import com.gemwallet.android.data.stake.RoomDelegationValidator
import com.gemwallet.android.data.stake.StakeDao
import com.gemwallet.android.data.tokens.TokenRoom
import com.gemwallet.android.data.tokens.TokensDao
import com.gemwallet.android.data.transaction.TransactionRoom
import com.gemwallet.android.data.transaction.TransactionsDao
import com.gemwallet.android.data.transaction.TxSwapMetadataRoom
import com.gemwallet.android.data.wallet.AccountRoom
import com.gemwallet.android.data.wallet.AccountsDao
import com.gemwallet.android.data.wallet.WalletRoom
import com.gemwallet.android.data.wallet.WalletsDao

@Database(
    version = 25,
    entities = [
        WalletRoom::class,
        AccountRoom::class,
        AssetRoom::class,
        BalanceRoom::class,
        PriceRoom::class,
        TokenRoom::class,
        TransactionRoom::class,
        TxSwapMetadataRoom::class,
        RoomConnection::class,
        RoomDelegationValidator::class,
        RoomDelegationBase::class,
    ],
)
abstract class RoomService : RoomDatabase() {
    abstract fun walletsDao(): WalletsDao

    abstract fun accountsDao(): AccountsDao

    abstract fun assetsDao(): AssetsDao

    abstract fun balancesDao(): BalancesDao

    abstract fun pricesDao(): PricesDao

    abstract fun tokensDao(): TokensDao

    abstract fun transactionsDao(): TransactionsDao

    abstract fun connectionsDao(): ConnectionsDao

    abstract fun stakeDao(): StakeDao
}