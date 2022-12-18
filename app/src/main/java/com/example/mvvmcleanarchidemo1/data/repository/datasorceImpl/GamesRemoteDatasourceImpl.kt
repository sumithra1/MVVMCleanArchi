package com.example.mvvmcleanarchidemo1.data.repository.datasorceImpl

import com.example.mvvmcleanarchidemo1.data.api.GamesAPIService
import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemoteDatasource
import retrofit2.Response

class GamesRemoteDatasourceImpl(private val gamesAPIService: GamesAPIService):GamesRemoteDatasource {
    override suspend fun getGamesData(): Response<GamesAPIResponseMario> {
      return  gamesAPIService.getGamesData()
    }
}