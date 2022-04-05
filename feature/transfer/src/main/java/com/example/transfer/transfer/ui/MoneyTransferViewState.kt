package com.example.transfer.transfer.ui

import com.example.presentation.viewstate.ViewState

sealed class MoneyTransferViewState : ViewState {
    data class Loading(val status: Boolean) : MoneyTransferViewState()
    data class Error(val e: Throwable) : MoneyTransferViewState()
}