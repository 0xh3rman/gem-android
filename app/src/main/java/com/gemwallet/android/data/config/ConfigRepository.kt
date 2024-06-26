package com.gemwallet.android.data.config

import com.wallet.core.primitives.Chain
import com.wallet.core.primitives.ChainNodes
import com.wallet.core.primitives.FiatAssets
import com.wallet.core.primitives.Node

interface ConfigRepository {

    fun authRequired(): Boolean

    fun setAuthRequired(enabled: Boolean)

    fun getAppVersion(): String

    fun setAppVersion(version: String, type: AppVersionType)

    fun appVersionActual(current: String): Boolean

    fun getAppVersionSkip(): String

    fun setAppVersionSkip(version: String)

    fun getNodesVersion(): Int

    fun setNodesVersion(version: Int)

    fun nodesActual(): Boolean

    fun getNode(chain: Chain): List<Node>

    fun getCurrentNode(chain: Chain): Node?

    fun setCurrentNode(chain: Chain, node: Node)

    fun setNodes(version: Int, nodes: List<ChainNodes>)

    fun getFiatAssetsVersion(): Int

    fun setFiatAssetsVersion(version: Int)

    fun setAvailableTokenListVersion(version: Int)

    fun setAvailableTokenListVersion(chain: String, version: Int)

    fun setOfflineListVersion(version: Int)

    fun setOfflineTokenListVersion(chain: String, version: Int)

    fun getFiatAssets(): FiatAssets

    fun setFiatAssets(assets: FiatAssets)

    fun postNotificationsGranted(granted: Boolean)

    fun postNotificationsGranted(): Boolean

    fun pushEnabled(enabled: Boolean)

    fun pushEnabled(): Boolean

    fun updateDeviceId()

    fun getDeviceId(): String

    fun getPushToken(): String

    fun setPushToken(token: String)

    fun developEnabled(enabled: Boolean)

    fun developEnabled(): Boolean

    fun getTxSyncTime(): Long

    fun setTxSyncTime(time: Long)

    fun getSubscriptionVersion(): Int

    fun setSubscriptionVersion(subVersion: Int)

    fun increaseSubscriptionVersion()

    enum class AppVersionType {
        Alpha,
        Beta,
        Prod,
    }

    companion object {
        fun getGemNodeUrl(chain: Chain) = "https://${chain.string}.gemnodes.com"
    }
}