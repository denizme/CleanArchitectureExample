package com.example.account.setting.ui

import com.example.presentation.viewstate.ViewState

sealed class SettingViewState : ViewState {
    data class Loading(val status: Boolean) : SettingViewState()
    data class Error(val e: Throwable) : SettingViewState()
}