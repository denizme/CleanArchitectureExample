package com.example.campaign.ui

import com.example.presentation.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CampaignViewModel @Inject constructor() : BaseViewModel<CampaignViewState>()