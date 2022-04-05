package com.example.campaign.ui

import com.example.presentation.viewstate.ViewState

sealed class CampaignViewState : ViewState {
    data class Loading(val status: Boolean) : CampaignViewState()
    data class Error(val e: Throwable) : CampaignViewState()
}