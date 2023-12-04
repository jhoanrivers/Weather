package com.example.privytest.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("cod")
    val cod: String,

    @SerializedName("message")
    val message: Int,

    @SerializedName("city")
    val city: CityEntity,


    @SerializedName("list")
    val listWeather:List<WeatherEntity>,



    )