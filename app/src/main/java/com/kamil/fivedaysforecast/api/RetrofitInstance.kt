package com.kamil.fivedaysforecast.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

//class RetrofitInstance {
//
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    val api: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
//}