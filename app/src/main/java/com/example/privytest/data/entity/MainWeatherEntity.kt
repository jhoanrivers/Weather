package com.example.privytest.data.entity

import com.google.gson.annotations.SerializedName

data class MainWeatherEntity(

//    "temp": 275.44,
//    "feels_like": 273.35,
//"temp_min": 275.24,
//"temp_max": 275.44,
//"pressure": 1015,
//"sea_level": 1015,
//"grnd_level": 983,
//"humidity": 95,
//"temp_kf": 0.2

    @SerializedName("temp")
    val temp: Double,


    @SerializedName("temp_min")
    val tempMin: Double,


    @SerializedName("temp_max")
    val tempMax: Double

    )
