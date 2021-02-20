package com.kamil.fivedaysforecast.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class City(

    val coord: Coord,

    val country: String,

    val id: Int,

    val name: String,

    val population: Int,

    val sunrise: Int,

    val sunset: Int,

    val timezone: Int
)