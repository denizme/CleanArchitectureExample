package com.example.home.dashboard.data.remote.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DashboardServiceModule {

    @Provides
    @Singleton
    fun provideDashboardService(retrofit: Retrofit): DashboardService {
        return retrofit.create(DashboardService::class.java)
    }
}