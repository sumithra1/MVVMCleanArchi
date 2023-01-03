package com.example.core_testing

import com.example.data.api.GamesApiService
import com.example.data.models.GamesAPIResponse


class GameFakeService(private val gamesData: GamesAPIResponse): GamesApiService {
    override suspend fun getGamesData(): GamesAPIResponse {
        return gamesData
    }

}