package com.example.home.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.domain.model.UserRepo
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
    //private val context: Application,
    private val userRepoUseCase: UserRepoUseCase
) : BaseViewModel() {

    private val _userRepoList: MutableLiveData<List<UserRepo>> = MutableLiveData()
    val userRepoList: LiveData<List<UserRepo>>
        get() = _userRepoList

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun searchUserRepos(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val params = UserRepoParams(userName = userName)
            val searchResult = userRepoUseCase.execute(params)
            withContext(Dispatchers.Main) {
                when (searchResult) {
                    is DataFetchResult.Success -> {
                        _userRepoList.postValue(searchResult.data)
                    }
                    is DataFetchResult.Failure -> {
                        searchResult.e.printStackTrace()
                        _errorMessage.postValue(searchResult.e.message)
                    }
                    is DataFetchResult.Progress -> {}
                }
            }
        }
    }

}