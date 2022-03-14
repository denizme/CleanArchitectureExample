package com.example.home.dashboard.data.remote.datasource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DashboardRemoteDataSourceModule {

    @Binds
    abstract fun bindDashboardRemoteDataSource(remoteDataSource: DashboardRemoteDataSourceImpl): DashboardRemoteDataSource
}