package com.example.account.profile.ui

import com.example.presentation.viewstate.ViewState

sealed class ProfileViewState : ViewState {
    data class Loading(val status: Boolean) : ProfileViewState()
    data class Error(val e: Throwable) : ProfileViewState()
}