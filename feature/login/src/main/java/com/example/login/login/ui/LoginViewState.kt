package com.example.login.login.ui

import com.example.presentation.viewstate.ViewState

sealed class LoginViewState : ViewState {
    data class Loading(val status: Boolean) : LoginViewState()
    data class Error(val e: Throwable) : LoginViewState()
}