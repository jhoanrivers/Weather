package com.example.privytest.data

import com.example.privytest.di.network.ApiService
import com.example.privytest.data.entity.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getForecastWeather(id: String, appId: String) : Response<WeatherResponse> = apiService.getForecastWeather(id, appId)
}