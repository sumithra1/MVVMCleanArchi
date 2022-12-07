package com.example.mvvmcleanarchidemo1.data.model


import com.google.gson.annotations.SerializedName

data class Release(
    @SerializedName("au")
    val au: String,
    @SerializedName("eu")
    val eu: String,
    @SerializedName("jp")
    val jp: String,
    @SerializedName("na")
    val na: String
)