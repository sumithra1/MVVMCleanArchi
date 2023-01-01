package com.example.data.di

import com.example.data.repository.GamesRepoImpl
import com.example.data.repository.datasource.RemoteDataSource
import com.example.domain.repository.GamesRepo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class RepositoryModule {
    @Singleton
    @Provides
    fun provideGamesRepository(gamesRemoteDatasource: RemoteDataSource): GamesRepo {
        return GamesRepoImpl(gamesRemoteDatasource)
    }
}