package com.example.mvvmcleanarchidemo1.presentation.di

import com.example.mvvmcleanarchidemo1.data.repository.GamesRepoImpl
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemoteDatasource
import com.example.mvvmcleanarchidemo1.domain.repository.GamesRepository
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
    fun provideGamesRepository(gamesRemotedatasource: GamesRemoteDatasource):GamesRepository{
        return  GamesRepoImpl(gamesRemotedatasource)
    }
}