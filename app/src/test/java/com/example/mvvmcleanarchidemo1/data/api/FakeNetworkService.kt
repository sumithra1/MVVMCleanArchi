package com.example.mvvmcleanarchidemo1.data.api


import com.example.data.api.GamesApiService
import com.example.data.models.GamesAPIResponse


class FakeNetworkService(private val gamesData: GamesAPIResponse): GamesApiService {
    override suspend fun getGamesData(): GamesAPIResponse {
        return gamesData
    }

}