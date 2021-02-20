package com.kamil.fivedaysforecast.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

//    const val API_KEY = "2ae1ab5ff36544b5dda851f5982e3872"

    companion object {
        val baseURL = "http://api.openweathermap.org/data/2.5/"
        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}