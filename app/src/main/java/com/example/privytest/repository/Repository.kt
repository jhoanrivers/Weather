package com.example.privytest.repository

import com.example.privytest.di.network.ApiService
import com.example.privytest.entity.WeatherResponse
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {


   fun getRandomData()  = apiService.getRandomDog()


}