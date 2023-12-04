package com.example.privytest.repository

import com.example.privytest.data.RemoteDataSource
import com.example.privytest.di.network.BaseApiResponse
import com.example.privytest.di.network.NetworkResult
import com.example.privytest.data.entity.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


interface Repository  {
   suspend fun getForecastWeather(cityId: String, appId: String) : Flow<NetworkResult<WeatherResponse>>


   fun sampleListWeather() : WeatherResponse

}