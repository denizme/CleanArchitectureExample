package com.example.home.dashboard.domain.usecase

import com.example.core.data.models.DataFetchResult
import com.example.core.domain.usecase.UseCase
import com.example.core.domain.usecase.UseCaseParams
import com.example.home.dashboard.domain.mapper.UserRepoMapper
import com.example.home.dashboard.domain.model.UserRepo
import com.example.home.dashboard.domain.repository.DashboardRepository
import javax.inject.Inject

class UserRepoUseCase @Inject constructor(
    private val repository: DashboardRepository,
    private val mapper: UserRepoMapper
) : UseCase.GenericUseCase<UserRepoParams, List<UserRepo>> {

    override suspend fun execute(params: UserRepoParams): DataFetchResult<List<UserRepo>> =
        try {
            when (val result = repository.getUserRepos(params.userName)) {
                is DataFetchResult.Success -> {
                    val list = mapper.invoke(result.data)
                    DataFetchResult.success(list)
                }
                is DataFetchResult.Failure -> {
                    DataFetchResult.failure(result.e)
                }
                is DataFetchResult.Progress -> {
                    //todo düzenlecenek
                    DataFetchResult.loading(false)
                }
            }
        } catch (e: Exception) {
            DataFetchResult.failure(e)
        }
}

data class UserRepoParams(val userName: String) : UseCaseParams()