package com.example.mvvmcleanarchidemo1.data.repository.datasource

import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import retrofit2.Response

interface GamesRemotedatasource
{
    suspend fun getGamesData():Response<GamesAPIResponseMario>
}