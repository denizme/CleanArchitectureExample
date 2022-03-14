package com.example.di.modules

import com.example.core.qualifiers.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @BaseUrl
    @Singleton
    @Provides
    fun provideBaseUrl() = "https://api.github.com/"
}