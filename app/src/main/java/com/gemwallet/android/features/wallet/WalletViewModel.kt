package com.gemwallet.android.features.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gemwallet.android.blockchain.operators.LoadPhraseOperator
import com.gemwallet.android.blockchain.operators.PasswordStore
import com.gemwallet.android.data.session.SessionRepository
import com.gemwallet.android.data.wallet.WalletsRepository
import com.gemwallet.android.interactors.getIconUrl
import com.wallet.core.primitives.Wallet
import com.wallet.core.primitives.WalletType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val walletsRepository: WalletsRepository,
    private val passwordStore: PasswordStore,
    private val loadPhraseOperator: LoadPhraseOperator,
    private val sessionRepository: SessionRepository,
) : ViewModel() {
    private val state = MutableStateFlow(WalletViewModelState())
    val uiState = state
        .map { it.toUIState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, WalletUIState.Success())

    fun init(walletId: String, isPhrase: Boolean) {
        viewModelScope.launch {
            walletsRepository.getWallet(walletId)
                .onSuccess {  wallet ->
                    state.update { it.copy(wallet = wallet) }
                }
                .onFailure {
                    state.update { it.copy(error = "Wallet not found") }
                }
            if (isPhrase) {
                handleShowPhrase()
            }
        }
    }

    fun setWalletName(name: String) {
        viewModelScope.launch {
            val wallet = state.value.wallet ?: return@launch
            walletsRepository.updateWallet(wallet.copy(name = name))
            if (wallet.id == sessionRepository.session?.wallet?.id) {
                val newWallet = walletsRepository.getWallet(wallet.id).getOrNull() ?: return@launch
                sessionRepository.setWallet(newWallet)
            }
        }
    }

    private suspend fun handleShowPhrase() {
        try {
            val walletId = state.value.wallet?.id ?: return
            val password = passwordStore.getPassword(walletId)
            val phrase = loadPhraseOperator(walletId, password)
            state.update {
                it.copy(phrase = phrase)
            }
        } catch (err: Throwable) {
            state.update { it.copy(error = err.message) }
        }
    }
}

data class WalletViewModelState(
    val wallet: Wallet? = null,
    val phrase: String = "",
    val error: String? = null,
) {
    fun toUIState() = when {
        error != null -> WalletUIState.Fatal(error)
        wallet == null -> WalletUIState.Fatal("Wallet doesn't found")
        phrase.isNotEmpty() -> {
            WalletUIState.Phrase(
                walletName = wallet.name,
                words = if (phrase.isEmpty()) emptyList() else phrase.split(" "),
            )
        }
        else -> WalletUIState.Success(
            walletName = wallet.name,
            walletType = wallet.type,
            walletAddress = wallet.accounts.firstOrNull()?.address ?: "",
            chainIconUrl = wallet.accounts.firstOrNull()?.chain?.getIconUrl() ?: "",
        )
    }
}

sealed interface WalletUIState {
    data class Fatal(
        val message: String,
    ) : WalletUIState

    data class Success(
        val walletType: WalletType = WalletType.view,
        val walletName: String = "",
        val walletAddress: String = "",
        val chainIconUrl: String = "",
    ) : WalletUIState

    data class Phrase(
        val walletName: String,
        val words: List<String> = emptyList(),
    ) : WalletUIState
}

