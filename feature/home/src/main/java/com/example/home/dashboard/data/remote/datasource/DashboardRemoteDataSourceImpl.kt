package com.example.home.dashboard.data.remote.datasource

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.data.remote.service.DashboardService
import javax.inject.Inject

class DashboardRemoteDataSourceImpl @Inject constructor(
    private val service: DashboardService,
) : DashboardRemoteDataSource {

    override suspend fun getUserRepos(userName: String): DataFetchResult<List<UserRepoResponse>> =
        try {
            val response = service.getUserRepos(userName = userName)
            DataFetchResult.success(response)
        } catch (e: java.lang.Exception) {
            DataFetchResult.failure(e)
        }
}