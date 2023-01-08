package com.example.mvvmcleanarchidemo1.presentation.viewmodel

import com.example.data.models.AmiiboDTO
import com.example.data.models.GamesAPIResponseDTO

object FakeDataGenerator {

    val amiibo=GamesAPIResponseDTO(listOf(AmiiboDTO("Super Smash Bros","https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png","Mario")))

}