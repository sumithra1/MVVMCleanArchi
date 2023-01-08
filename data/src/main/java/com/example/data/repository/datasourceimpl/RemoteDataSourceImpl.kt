package com.example.data.repository.datasourceimpl

import com.example.data.api.GamesApiService
import com.example.data.mapper.mapToGameDomain
import com.example.data.repository.datasource.RemoteDataSource
import com.example.domain.entity.GamesDomainMario
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: GamesApiService) :
    RemoteDataSource {
    override suspend fun getGamesData(): GamesDomainMario {
        val gamesData = service.getGamesData()
        return mapToGameDomain(gamesData)
    }
}



