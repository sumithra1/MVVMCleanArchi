package com.example.domain.repository


import com.example.domain.entity.GamesDomainMario

interface  GamesRepo {
    suspend fun  getGamesData(): GamesDomainMario
}