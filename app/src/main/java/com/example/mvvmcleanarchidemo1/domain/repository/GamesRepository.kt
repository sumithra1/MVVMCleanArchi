package com.example.mvvmcleanarchidemo1.domain.repository

import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.util.Resource

interface GamesRepository
{
  suspend fun  getGamesData():Resource<GamesAPIResponseMario>
}