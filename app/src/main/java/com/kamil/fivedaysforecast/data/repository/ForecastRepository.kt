package com.kamil.fivedaysforecast.data.repository

import kotlinx.coroutines.Job

interface ForecastRepository {
    suspend fun getCurrentWeather(): Job

}