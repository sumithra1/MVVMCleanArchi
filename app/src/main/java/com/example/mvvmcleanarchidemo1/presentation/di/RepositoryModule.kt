package com.example.mvvmcleanarchidemo1.presentation.di

import com.example.mvvmcleanarchidemo1.data.repository.GamesRepoImpl
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemotedatasource
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
    fun provideGamesRepoitory(gamesRemotedatasource: GamesRemotedatasource):GamesRepository{
        return  GamesRepoImpl(gamesRemotedatasource)
    }
}