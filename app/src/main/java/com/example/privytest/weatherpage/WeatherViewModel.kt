package com.example.privytest.weatherpage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.privytest.Constant
import com.example.privytest.WeatherApplication
import com.example.privytest.di.network.NetworkResult
import com.example.privytest.entity.WeatherEntity
import com.example.privytest.entity.WeatherResponse
import com.example.privytest.repository.Repository
import com.example.privytest.weatherpage.model.WeatherModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {


    val listWeather = MutableLiveData<NetworkResult<WeatherResponse>>()
    val cloudsWeather = MutableLiveData<List<WeatherModel>>()
    val rainWeather = MutableLiveData<List<WeatherModel>>()
    val clearWeather = MutableLiveData<List<WeatherModel>>()
    val snowWeather = MutableLiveData<List<WeatherModel>>()


    fun getForecastWeather() = viewModelScope.launch {


        val listOfClouds = mutableListOf<WeatherModel>()
        val listOfRain = mutableListOf<WeatherModel>()
        val listOfClear = mutableListOf<WeatherModel>()
        val listOfSnow = mutableListOf<WeatherModel>()


        repository.getForecastWeather("4899170", Constant.APPID)
            .collect{ value ->
                value.data?.listWeather?.map { weatherEntity ->

                    val dataWeather = weatherEntity.dataWeather.first()
                    if(dataWeather.main == "clouds") {
                        listOfClouds.add(
                            WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        )
                    } else if (dataWeather.main == "rain") {
                        listOfRain.add(
                            WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        )
                    } else if(dataWeather.main == "snow") {
                        listOfSnow.add(
                            WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        )
                    } else {
                        listOfClear.add(
                            WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        )
                    }
                }
                rainWeather.postValue(listOfRain)
                cloudsWeather.postValue(listOfClouds)
                clearWeather.postValue(listOfClear)
                snowWeather.postValue(listOfSnow)

            }
    }






}