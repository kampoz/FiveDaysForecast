package com.kamil.fivedaysforecast.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.kamil.fivedaysforecast.data.network.ApiService
import com.kamil.fivedaysforecast.data.network.response.ForecastResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(
//    forecastRepository: ForecastRepository
) : WeatherViewModel() {

    private var apiService: ApiService = ApiService()
    var recyclerListData: MutableLiveData<ForecastResponse> = MutableLiveData()

    fun makeApiCall(cityName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiService.getWeather(cityName)
            recyclerListData.postValue(response)
        }
    }
}