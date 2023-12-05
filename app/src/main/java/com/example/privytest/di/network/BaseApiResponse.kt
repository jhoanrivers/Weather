package com.example.privytest.di.network

import android.net.Network
import com.example.privytest.Utils.NetworkEnum
import retrofit2.Response

open class BaseApiResponse {


    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>) : NetworkResult<T> {
        try {
            val response = apiCall()
            if(response.isSuccessful){
                val body = response.body()
                body?.let {
                    return NetworkResult(NetworkEnum.SUCCESS, body)
                }
            }
            return NetworkResult(NetworkEnum.ERROR, null, "${
                response.code()} ${response.message()}")
        } catch (e: java.lang.Exception) {
            return NetworkResult(NetworkEnum.LOADING, null, null)
        }
    }

    private fun<T> error(errorMessage: String) : NetworkResult<T> =
        NetworkResult(NetworkEnum.ERROR, null, errorMessage)

}