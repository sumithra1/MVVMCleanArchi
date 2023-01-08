package com.example.domain.usecase

import com.example.domain.entity.GamesDomainMario
import com.example.domain.repository.GamesRepo

class FakeGamesRepo: GamesRepo {
    override suspend fun getGamesData(): GamesDomainMario {

        return GamesDomainMario(FakeDataGenerator.amiiboList)
    }
}