package com.example.mvvmcleanarchidemo1.data.model


import com.google.gson.annotations.SerializedName

data class Amiibo(
    @SerializedName("amiiboSeries")
    val amiiboSeries: String,

    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,


)