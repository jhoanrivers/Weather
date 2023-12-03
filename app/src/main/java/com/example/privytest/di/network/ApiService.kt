package com.example.privytest.di.network

import com.example.privytest.Constant.END_POINT
import com.example.privytest.entity.ApiResponse
import com.example.privytest.entity.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET(END_POINT)
    fun getRandomDog() : Single<ApiResponse>
}