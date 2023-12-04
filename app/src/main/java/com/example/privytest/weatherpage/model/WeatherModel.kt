package com.example.privytest.weatherpage.model

data class WeatherModel(

    var count: Int = 1,

    val cityName: String,

    val cityId: String,

    val main : String,

    val icon: String,

    val maxTemp: String,

    val minTemp : String,

    val currentTemp: String,
)