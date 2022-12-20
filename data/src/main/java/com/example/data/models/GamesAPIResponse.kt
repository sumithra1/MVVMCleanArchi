package com.example.data.models


import com.google.gson.annotations.SerializedName

data class GamesAPIResponse(
    @SerializedName("amiibo")
    val amiibo: List<Amiibo>
)