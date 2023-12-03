package com.example.privytest.entity

import com.google.gson.annotations.SerializedName

data class DataWeatherEntity(


    @SerializedName("main")
    val main: String,


    @SerializedName("icon")
    val icon: String
)
