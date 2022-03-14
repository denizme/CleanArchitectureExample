package com.example.home.dashboard.domain.mapper

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun provideUserRepoMapper(): UserRepoMapper = UserRepoMapper()
}