package com.example.data.mapper

import com.example.data.models.Amiibo
import com.example.data.models.GamesAPIResponse
import com.example.domain.entity.GamesDomainMario


fun mapToGameDomain(gamesAPIResponseMario: GamesAPIResponse): GamesDomainMario {
    return GamesDomainMario(mapToGameAmiibo(gamesAPIResponseMario.amiibo))
}

fun mapToGameAmiibo(amiibo: List<Amiibo>): List<com.example.domain.entity.Amiibo> {

    val list = amiibo.map {
        com.example.domain.entity.Amiibo(
            amiiboSeries = it.amiiboSeries,
            image = it.image,
            name = it.name,
            )
    }
    return list
}