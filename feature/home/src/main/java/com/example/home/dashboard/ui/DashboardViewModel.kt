package com.example.home.dashboard.ui

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.domain.usecase.UserRepoParams
import com.example.home.dashboard.domain.usecase.UserRepoUseCase
import com.example.presentation.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val context: Application,
    private val userRepoUseCase: UserRepoUseCase
) : BaseViewModel<DashboardViewState>() {

    fun searchUserRepos(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val params = UserRepoParams(userName = userName)
            val searchResult = userRepoUseCase.execute(params)
            withContext(Dispatchers.Main) {
                when (searchResult) {
                    is DataFetchResult.Success -> {
                        _viewState.postValue(DashboardViewState.UserRepoList(searchResult.data))
                    }
                    is DataFetchResult.Failure -> {
                        searchResult.e.printStackTrace()
                        _viewState.postValue(DashboardViewState.Error(searchResult.e))
                    }
                    is DataFetchResult.Progress -> {
                        _viewState.postValue(DashboardViewState.Loading(searchResult.loading))
                    }
                }
            }
        }
    }
}