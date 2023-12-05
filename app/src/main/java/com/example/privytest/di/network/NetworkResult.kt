package com.example.privytest.di.network

import com.example.privytest.Utils.NetworkEnum

data class NetworkResult<out T>(
    val status: NetworkEnum,
    val data: T?,
    val message: String ? = null
    ) {

    fun<T> onSuccess(data: T?) : NetworkResult<T> {
        return NetworkResult(NetworkEnum.SUCCESS, data, null)
    }

    fun<T> onError(message: String, data: T?) : NetworkResult<T>{
        return NetworkResult(NetworkEnum.ERROR, data, message)
    }

    fun<T> onLoading(data: T?): NetworkResult<T>{
        return NetworkResult(NetworkEnum.LOADING, data)
    }

}