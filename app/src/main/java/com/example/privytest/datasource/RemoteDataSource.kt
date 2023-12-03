package com.example.privytest.datasource

import com.example.privytest.di.network.ApiService
import com.example.privytest.entity.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getForecastWeather(id: String, appId: String) : Response<WeatherResponse> = apiService.getForecastWeather(id, appId)
}