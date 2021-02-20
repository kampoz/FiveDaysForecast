package com.kamil.fivedaysforecast.data.network.response

import com.google.gson.annotations.SerializedName


data class ForecastResponse(

    val city: City,

    val cnt: Int,

    val cod: String,
    @SerializedName("list")
    val timePeriods: ArrayList<TimePeriodItem>,
)