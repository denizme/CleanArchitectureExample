package com.example.home.dashboard.data.remote.service

import com.example.home.dashboard.data.remote.model.UserRepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DashboardService {

    @GET("users/{userName}/repos")
    suspend fun getUserRepos(@Path("userName") userName: String): List<UserRepoResponse>
}