package com.example.data.models


import com.google.gson.annotations.SerializedName

data class GamesAPIResponseDTO(
    @SerializedName("amiibo")
    val amiibo: List<AmiiboDTO>
)