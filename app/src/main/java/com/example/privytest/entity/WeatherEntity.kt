package com.example.privytest.entity

import com.google.gson.annotations.SerializedName

data class WeatherEntity(

    @SerializedName("main")
    val mainWeather: MainWeatherEntity,


    @SerializedName("weather")
    val dataWeather: DataWeatherEntity


)
