package com.example.mvvmcleanarchidemo1.data.repository

import android.util.Log
import com.example.mvvmcleanarchidemo1.data.model.Amiibo
import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemoteDatasource
import com.example.mvvmcleanarchidemo1.data.util.Resource
import com.example.mvvmcleanarchidemo1.domain.repository.GamesRepository
import retrofit2.Response
import java.lang.Exception

class GamesRepoImpl( private  val  gamesRemote:GamesRemoteDatasource):GamesRepository {
    override suspend fun getGamesData(): List<Amiibo> {
        return responseToResource()
    }


    suspend fun responseToResource(): List<Amiibo> {

        lateinit var gamelist: List<Amiibo>
        try {
            val response = gamesRemote.getGamesData()
            val body = response.body()
            if (body != null) {
                gamelist = body.amiibo
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return gamelist


    }
}