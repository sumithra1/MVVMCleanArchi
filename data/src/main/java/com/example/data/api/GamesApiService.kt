package com.example.data.api


import com.example.data.models.GamesAPIResponseDTO
import retrofit2.http.GET

interface GamesApiService {
    @GET("api/amiibo/")
    suspend fun getGamesData(): GamesAPIResponseDTO

}