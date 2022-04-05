package com.example.transaction.menu.ui

import android.app.Application
import com.example.presentation.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionMenuViewModel @Inject constructor(
    private val context: Application
) : BaseViewModel<TransactionMenuViewState>()