package com.example.transaction.menu.ui

import com.example.presentation.viewstate.ViewState

sealed class TransactionMenuViewState : ViewState {
    data class Loading(val status: Boolean) : TransactionMenuViewState()
    data class Error(val e: Throwable) : TransactionMenuViewState()
}