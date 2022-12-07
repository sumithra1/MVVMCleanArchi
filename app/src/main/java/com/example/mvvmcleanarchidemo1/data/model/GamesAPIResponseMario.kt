package com.example.mvvmcleanarchidemo1.data.model


import com.google.gson.annotations.SerializedName

data class GamesAPIResponseMario(
    @SerializedName("amiibo")
    val amiibo: List<Amiibo>
)