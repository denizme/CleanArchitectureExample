package com.example.home.dashboard.data.remote.model

import com.example.core.data.models.BaseResponseModel

data class UserRepoResponse(
    var id: Long,
    var name: String,
    var full_name: String,
    var private: Boolean,
    var html_url: String,
    var description: String?,
    var fork: Boolean,
    var watchers_count: Int,
    var stargazers_count: Int
) : BaseResponseModel()