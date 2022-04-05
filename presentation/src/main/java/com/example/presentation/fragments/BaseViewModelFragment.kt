package com.example.presentation.fragments

import androidx.lifecycle.ViewModel
import com.example.presentation.viewstate.ViewState

abstract class BaseViewModelFragment<VS : ViewState, VM : ViewModel> : BaseFragment() {

    protected abstract val viewModel: VM

    abstract fun renderViewState(viewState: VS)
}