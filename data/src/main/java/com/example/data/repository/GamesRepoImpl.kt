package com.example.data.repository

import com.example.data.repository.datasource.RemoteDataSource
import com.example.domain.entity.GamesDomainMario
import com.example.domain.repository.GamesRepo

class GamesRepoImpl(
    private val gamesRemote: RemoteDataSource,
    ) : GamesRepo {
    override suspend fun getGamesData(): GamesDomainMario {
        return gamesRemote.getGamesData()
    }
}