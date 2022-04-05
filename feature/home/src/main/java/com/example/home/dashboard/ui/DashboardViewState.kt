package com.example.home.dashboard.ui

import com.example.home.dashboard.domain.model.UserRepo
import com.example.presentation.viewstate.ViewState

sealed class DashboardViewState : ViewState {
    data class Loading(val status: Boolean) : DashboardViewState()
    data class Error(val e: Throwable) : DashboardViewState()
    data class UserRepoList(val data: List<UserRepo>) : DashboardViewState()
}