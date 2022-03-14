package com.example.home.dashboard.domain.mapper

import com.example.core.domain.mapper.Mapper
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.domain.model.UserRepo

class UserRepoMapper : Mapper<List<UserRepoResponse>, List<UserRepo>> {

    override suspend fun invoke(input: List<UserRepoResponse>): List<UserRepo> {
        return input.map {
            UserRepo(
                name = it.name,
                description = it.description,
                id = it.id
            )
        }
    }
}