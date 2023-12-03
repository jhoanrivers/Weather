package com.example.privytest.weatherpage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.privytest.WeatherApplication
import com.example.privytest.entity.ApiResponse
import com.example.privytest.entity.WeatherEntity
import com.example.privytest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val dogResponse = MutableLiveData<ApiResponse>()
    val errorResponse = MutableLiveData<String>()

    private lateinit var disposable: Disposable

    fun getRandomDogs() {
        disposable = repository.getRandomData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {sucess -> dogResponse.postValue(sucess)},
                {error -> errorResponse.postValue(error.message)}
            )
    }


    override fun onCleared() {
        super.onCleared()
        if(this::disposable.isInitialized)
            disposable.dispose()
    }







}