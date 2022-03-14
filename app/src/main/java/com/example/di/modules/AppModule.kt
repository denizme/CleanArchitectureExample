package com.example.di.modules

import com.example.BuildConfig
import com.example.core.qualifiers.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @BaseUrl
    @Singleton
    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL
}