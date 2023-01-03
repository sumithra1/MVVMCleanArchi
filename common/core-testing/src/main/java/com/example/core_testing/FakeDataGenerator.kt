package com.example.core_testing

import com.example.data.models.Amiibo
import com.example.data.models.GamesAPIResponse

object FakeDataGenerator {

    val amiibo=GamesAPIResponse(listOf(Amiibo("Super Smash Bros","https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png","Mario")))

}