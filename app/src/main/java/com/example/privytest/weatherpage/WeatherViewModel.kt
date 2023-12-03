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
    val cloudsWeather = MutableLiveData<Map<String, WeatherModel>>()
    val rainWeather = MutableLiveData<Map<String, WeatherModel>>()
    val clearWeather = MutableLiveData<Map<String, WeatherModel>>()
    val snowWeather = MutableLiveData<Map<String, WeatherModel>>()


    val listCity = listOf<String>(
        "4899170",
        "6244895",
        "2661039",
        "5879092",
        "6198431",
        "5780908",
        "5781070",
        "792680",
        "2662148",
        "4350049",
    )




    fun getForecastWeather() = viewModelScope.launch {

        val mapOfClouds = mutableMapOf<String, WeatherModel>()
        val mapOfRain = mutableMapOf<String, WeatherModel>()
        val mapOfClear = mutableMapOf<String, WeatherModel>()
        val mapOfSnow = mutableMapOf<String, WeatherModel>()


        for(item in listCity){
            repository.getForecastWeather(item, Constant.APPID).collect{ value ->
                value.data?.listWeather?.map { weatherEntity ->

                    val dataWeather = weatherEntity.dataWeather.first()
                    if(dataWeather.main.equals("clouds", true)) {
                        if(mapOfClouds.containsKey(value.data.city.id.toString()))
                        {
                            mapOfClouds[value.data.city.id.toString()]?.count = mapOfClouds[value.data.city.id.toString()]?.count!! + 1
                        } else{
                            mapOfClouds[value.data.city.id.toString()] = WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        }

                    } else if (dataWeather.main.equals("rain", true)) {

                        if(mapOfRain.containsKey(value.data.city.id.toString())) {
                            mapOfRain[value.data.city.id.toString()]?.count = mapOfRain[value.data.city.id.toString()]?.count!! + 1
                        } else {
                            mapOfRain[value.data.city.id.toString()] = WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        }

                    } else if(dataWeather.main.equals("snow", true)) {

                        if(mapOfSnow.containsKey(value.data.city.id.toString())) {
                            mapOfSnow[value.data.city.id.toString()]?.count = mapOfSnow[value.data.city.id.toString()]?.count!! + 1
                        } else {
                            mapOfSnow[value.data.city.id.toString()] = WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        }

                    } else if(dataWeather.main.equals("clear", true)){
                        if(mapOfClear.containsKey(value.data.city.id.toString())) {
                            mapOfClear[value.data.city.id.toString()]?.count = mapOfClear[value.data.city.id.toString()]?.count!! + 1
                        } else {
                            mapOfClear[value.data.city.id.toString()] = WeatherModel(
                                cityName = value.data.city.name,
                                cityId = value.data.city.id.toString(),
                                main = dataWeather.main,
                                currentTemp = weatherEntity.mainWeather.temp.toString(),
                                icon = dataWeather.icon,
                                maxTemp = weatherEntity.mainWeather.tempMax.toString(),
                                minTemp = weatherEntity.mainWeather.tempMin.toString()
                            )
                        }
                    }
                }
                rainWeather.postValue(mapOfRain)
                cloudsWeather.postValue(mapOfClouds)
                clearWeather.postValue(mapOfClear)
                snowWeather.postValue(mapOfSnow)
                println("valuenya ${value.data?.listWeather?.size}")

            }
        }

    }


}