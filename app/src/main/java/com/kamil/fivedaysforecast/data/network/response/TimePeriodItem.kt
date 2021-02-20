package com.kamil.fivedaysforecast.data.network.response


import com.google.gson.annotations.SerializedName

data class TimePeriodItem(
//    val clouds: Clouds,
//    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    val main: Main,
//    val pop: Double,
//    val rain: Rain,
//    val snow: Snow,
//    val sys: Sys,
//    val visibility: Int,
//    val weather: List<Weather>,
//    val wind: Wind
)