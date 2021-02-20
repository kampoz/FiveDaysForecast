package com.kamil.fivedaysforecast.data.network

import com.kamil.fivedaysforecast.data.network.response.ForecastResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "2ae1ab5ff36544b5dda851f5982e3872"
const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

//http://api.openweathermap.org/data/2.5/forecast?q=lublin,pl&appid=2ae1ab5ff36544b5dda851f5982e3872

interface ApiService {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") location: String
    ): ForecastResponse

    companion object {
        operator fun invoke(): ApiService {
            val requestIncerceptor = Interceptor { chain: Interceptor.Chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestIncerceptor)
                .addInterceptor(ConnectivityInterceptorImpl())
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

    }
}