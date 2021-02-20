package com.kamil.fivedaysforecast.data.network.response


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val h: Double
)