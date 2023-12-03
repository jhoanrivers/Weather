package com.example.privytest.Utils

import com.example.privytest.weatherpage.model.WeatherModel
import java.text.DecimalFormat

object Utils {

    val decimalFormat = DecimalFormat("#.##")

    fun sortDescCountAscName(listWeather: List<WeatherModel>): List<WeatherModel>{
        val listWeather =  listWeather.sortedWith(compareByDescending<WeatherModel> { it.count }.thenBy { it.cityName })
        return listWeather
    }

}