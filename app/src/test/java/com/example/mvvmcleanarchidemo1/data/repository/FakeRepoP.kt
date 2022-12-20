package com.example.mvvmcleanarchidemo1.data.repository



import com.example.domain.entity.GamesDomainMario
import com.example.domain.repository.GamesRepo

class FakeRepo:GamesRepo {
    private val amiiboseries="amiboo"
    private  val name="Super"
    private val imageurl="https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png"
    private  val amiibo=com.example.domain.entity.Amiibo(amiiboseries,name,imageurl)
    private  val list= GamesDomainMario(listOf(amiibo))
    override suspend fun getGamesData(): GamesDomainMario {
        return list
    }


}