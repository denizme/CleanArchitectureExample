package com.example.core.domain.usecase

import com.example.core.data.models.DataFetchResult
import kotlinx.coroutines.flow.Flow


interface UseCase {

    interface GenericUseCase<in P, out T> : UseCase where P : UseCaseParams {
        suspend fun execute(params: P): DataFetchResult<T>
    }

    interface FlowableUseCase<in P, out T> : UseCase where P : UseCaseParams {
        suspend fun execute(params: P): Flow<DataFetchResult<T>>
    }
}