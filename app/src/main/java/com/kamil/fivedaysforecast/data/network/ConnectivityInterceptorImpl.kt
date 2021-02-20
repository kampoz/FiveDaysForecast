package com.kamil.fivedaysforecast.data.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl() : ConnectivityInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val code = response.code()
        if (code in 400..500) {
            throw MyIOException()
        }
        return response
    }

}
