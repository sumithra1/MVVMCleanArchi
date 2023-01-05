package com.example.data.models


import com.google.gson.annotations.SerializedName

data class AmiiboDTO(
    @SerializedName("amiiboSeries")
    val amiiboSeries: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    )