package com.example.mvvmcleanarchidemo1.data.api

import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import retrofit2.Response
import retrofit2.http.GET

interface GamesAPIService {
    @GET("api/amiibo/")
    suspend fun  getGamesData():Response<GamesAPIResponseMario>
}
