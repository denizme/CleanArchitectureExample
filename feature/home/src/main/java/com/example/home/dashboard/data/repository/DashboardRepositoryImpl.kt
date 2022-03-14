package com.example.home.dashboard.data.repository

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.datasource.DashboardRemoteDataSource
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.domain.repository.DashboardRepository
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val remoteDataSource: DashboardRemoteDataSource
) : DashboardRepository {

    override suspend fun getUserRepos(userName: String): DataFetchResult<List<UserRepoResponse>> =
        remoteDataSource.getUserRepos(userName = userName)
}