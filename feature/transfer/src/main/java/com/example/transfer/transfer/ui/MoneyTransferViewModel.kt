package com.example.transfer.transfer.ui

import android.app.Application
import com.example.presentation.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoneyTransferViewModel @Inject constructor(
    private val context: Application
) : BaseViewModel<MoneyTransferViewState>()