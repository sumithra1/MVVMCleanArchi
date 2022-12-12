package com.example.mvvmcleanarchidemo1.presentation.di

import com.example.mvvmcleanarchidemo1.domain.repository.GamesRepository
import com.example.mvvmcleanarchidemo1.domain.usecase.GamesUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Singleton
    @Provides
    fun provideGamesUsecase (gamesRepo:GamesRepository):GamesUsecase{
        return GamesUsecase(gamesRepo)
    }
}