package com.kamil.fivedaysforecast.data.network

import com.kamil.fivedaysforecast.data.network.response.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("forecast")
    suspend fun getWeather(@Query("q") location: String): ForecastResponse
}