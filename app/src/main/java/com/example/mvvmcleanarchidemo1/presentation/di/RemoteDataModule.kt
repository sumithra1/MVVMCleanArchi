package com.example.mvvmcleanarchidemo1.presentation.di

import com.example.mvvmcleanarchidemo1.data.api.GamesAPIService
import com.example.mvvmcleanarchidemo1.data.repository.datasorceImpl.GamesRemoteDatasourceImpl
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule
{
    @Singleton
    @Provides
    fun provideGamesRemoteDataSource(gamesAPIService: GamesAPIService):GamesRemoteDatasource{
        return GamesRemoteDatasourceImpl(gamesAPIService)
    }
}