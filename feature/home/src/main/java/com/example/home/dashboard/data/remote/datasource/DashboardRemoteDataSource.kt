package com.example.home.dashboard.data.remote.datasource

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.model.UserRepoResponse

interface DashboardRemoteDataSource {

    suspend fun getUserRepos(userName: String): DataFetchResult<List<UserRepoResponse>>
}