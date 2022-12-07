package com.example.mvvmcleanarchidemo1.domain.usecase

import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.util.Resource
import com.example.mvvmcleanarchidemo1.domain.repository.GamesRepository

class GamesUsecase(private  val gamesRepo:GamesRepository) {

    suspend fun  execute():Resource<GamesAPIResponseMario>{
        return gamesRepo.getGamesData()
    }

}