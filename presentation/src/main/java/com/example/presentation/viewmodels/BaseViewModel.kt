package com.example.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.presentation.viewstate.ViewState

abstract class BaseViewModel<VS : ViewState> : ViewModel() {
    protected val _viewState: MutableLiveData<VS> = MutableLiveData()
    val viewState: LiveData<VS>
        get() = _viewState
}