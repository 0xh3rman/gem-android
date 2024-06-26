package com.gemwallet.android.blockchain.clients.ethereum

import com.gemwallet.android.blockchain.rpc.model.JSONRpcMethod

enum class EvmMethod(val value: String) : JSONRpcMethod {
    GetBalance("eth_getBalance"),
    GetGasLimit("eth_estimateGas"),
    GetGasPrice("eth_gasPrice"),
    GetFeeHistory("eth_feeHistory"),
    GetNetVersion("net_version"),
    GetNonce("eth_getTransactionCount"),
    Broadcast("eth_sendRawTransaction"),
    Call("eth_call"),
    GetTransaction("eth_getTransactionReceipt"),
    GetTransactionByHash("eth_getTransactionByHash"),
    GetMaxPriorityFeePerGas("eth_maxPriorityFeePerGas")
    ;

    override fun value(): String = value
}