package com.example.home.dashboard.data.model

import com.example.home.dashboard.data.remote.model.UserRepoResponse

fun getUserRepoResponse() = UserRepoResponse(
    id = 1,
    name = "test",
    full_name = "test",
    private = false,
    fork = false,
    html_url = "test",
    description = "test",
    watchers_count = 1,
    stargazers_count = 1
)