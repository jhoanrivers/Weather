package com.example.privytest.di.network

import com.example.privytest.Utils.Constant.Companion.FORECAST_WEATHER_PATH
import com.example.privytest.data.entity.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(FORECAST_WEATHER_PATH)
    suspend fun getForecastWeather(
        @Query("id") cityId: String,
        @Query("appid") appid: String
    ) : Response<WeatherResponse>



}