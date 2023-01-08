package com.example.mvvmcleanarchidemo1.presentation.viewmodel

import com.example.data.api.GamesApiService
import com.example.data.models.GamesAPIResponseDTO


class GameFakeService(private val gamesData: GamesAPIResponseDTO) : GamesApiService {
    override suspend fun getGamesData(): GamesAPIResponseDTO {
        return gamesData
    }

}