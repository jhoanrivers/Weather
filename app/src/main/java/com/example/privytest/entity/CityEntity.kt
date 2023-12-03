package com.example.privytest.entity

import com.google.gson.annotations.SerializedName

data class CityEntity (

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,
 )