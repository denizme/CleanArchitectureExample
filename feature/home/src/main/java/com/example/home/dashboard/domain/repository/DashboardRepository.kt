package com.example.home.dashboard.domain.repository

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.model.UserRepoResponse

interface DashboardRepository {

    suspend fun getUserRepos(userName: String): DataFetchResult<List<UserRepoResponse>>
}