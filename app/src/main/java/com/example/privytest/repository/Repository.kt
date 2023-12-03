package com.example.privytest.repository

import android.net.Network
import com.example.privytest.datasource.RemoteDataSource
import com.example.privytest.di.network.ApiService
import com.example.privytest.di.network.BaseApiResponse
import com.example.privytest.di.network.NetworkResult
import com.example.privytest.entity.WeatherResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) : BaseApiResponse(){

   suspend fun getForecastWeather(cityId: String, appId: String) : Flow<NetworkResult<WeatherResponse>> {
      return flow {
         emit( safeApiCall { remoteDataSource.getForecastWeather(cityId, appId) })
      }.flowOn(Dispatchers.IO)
   }


}