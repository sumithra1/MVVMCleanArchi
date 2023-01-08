package com.example.data.di

import com.example.data.api.GamesApiService


import com.example.data.repository.datasource.RemoteDataSource
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideGamesRemoteDataSource(gamesAPIService: GamesApiService): RemoteDataSource {
        return RemoteDataSourceImpl(gamesAPIService)
    }

}
