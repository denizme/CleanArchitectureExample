package com.example.login.register.ui

import com.example.presentation.viewstate.ViewState

sealed class RegisterViewState : ViewState {
    data class Loading(val status: Boolean) : RegisterViewState()
    data class Error(val e: Throwable) : RegisterViewState()
}