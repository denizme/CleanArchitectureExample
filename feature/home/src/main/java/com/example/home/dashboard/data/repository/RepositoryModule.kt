package com.example.home.dashboard.data.repository

import com.example.home.dashboard.domain.repository.DashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(searchRepository: DashboardRepositoryImpl): DashboardRepository
}