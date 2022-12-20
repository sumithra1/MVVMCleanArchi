package com.example.domain.usecase


import com.example.domain.entity.GamesDomainMario
import com.example.domain.repository.GamesRepo
import javax.inject.Inject

class GamesUsecase @Inject constructor (private val gamesRepo:GamesRepo) {
    suspend fun  execute(): GamesDomainMario {
        return gamesRepo.getGamesData()
    }
}
