package com.example.data.repository.datasource

import com.example.domain.entity.GamesDomainMario


interface RemoteDataSource {
    suspend fun getGamesData(): GamesDomainMario
}


