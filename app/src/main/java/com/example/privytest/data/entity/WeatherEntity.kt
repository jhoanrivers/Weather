package com.example.privytest.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherEntity(

    @SerializedName("main")
    val mainWeather: MainWeatherEntity,


    @SerializedName("weather")
    val dataWeather: List<DataWeatherEntity>


)
