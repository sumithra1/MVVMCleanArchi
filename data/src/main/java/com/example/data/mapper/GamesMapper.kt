package com.example.data.mapper

import com.example.data.models.AmiiboDTO
import com.example.data.models.GamesAPIResponseDTO
import com.example.domain.entity.GamesDomainMario


fun mapToGameDomain(gamesAPIResponseMario: GamesAPIResponseDTO): GamesDomainMario {
    return GamesDomainMario(mapToGameAmiibo(gamesAPIResponseMario.amiibo))
}

fun mapToGameAmiibo(amiibo: List<AmiiboDTO>): List<com.example.domain.entity.Amiibo> {

    val list = amiibo.map {
        com.example.domain.entity.Amiibo(
            amiiboSeries = it.amiiboSeries,
            image = it.image,
            name = it.name,
            )
    }
    return list
}