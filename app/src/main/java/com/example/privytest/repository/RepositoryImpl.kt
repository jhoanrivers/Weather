package com.example.privytest.repository

import com.example.privytest.data.RemoteDataSource
import com.example.privytest.data.entity.*
import com.example.privytest.di.network.BaseApiResponse
import com.example.privytest.di.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :  Repository, BaseApiResponse(){

    override suspend fun getForecastWeather(cityId: String, appId: String) : Flow<NetworkResult<WeatherResponse>> {
        return flow {
            emit( safeApiCall { remoteDataSource.getForecastWeather(cityId, appId) })
        }.flowOn(Dispatchers.IO)
    }

    override fun sampleListWeather(): WeatherResponse {
        return WeatherResponse(
            cod = "200",
            message = 0,
            listWeather = listOf(
                WeatherEntity(
                    mainWeather = MainWeatherEntity(temp = 276.5, 275.5, 278.5),
                    dataWeather = listOf(
                        DataWeatherEntity(
                            main = "clouds",
                            icon = "10n"
                        )
                    )
                )
            ),
            city = CityEntity(
                id = 12354,
                name = "Indonesia"
            )
        )
    }


}