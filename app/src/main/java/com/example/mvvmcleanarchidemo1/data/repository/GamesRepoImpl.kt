package com.example.mvvmcleanarchidemo1.data.repository

import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.repository.datasource.GamesRemotedatasource
import com.example.mvvmcleanarchidemo1.data.util.Resource
import com.example.mvvmcleanarchidemo1.domain.repository.GamesRepository
import retrofit2.Response

class GamesRepoImpl( private  val  gamesRemote:GamesRemotedatasource):GamesRepository {
    override suspend fun getGamesData(): Resource<GamesAPIResponseMario> {
        return responseToResource(gamesRemote.getGamesData())
    }


private fun responseToResource(response:Response<GamesAPIResponseMario>):Resource<GamesAPIResponseMario>{
if (response.isSuccessful){
    response.body()?.let { result->return Resource.Success(result) }
}
    return  Resource.Error(response.message())

}


}