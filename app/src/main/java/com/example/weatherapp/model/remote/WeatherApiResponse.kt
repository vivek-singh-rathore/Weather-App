package com.example.weatherapp.model.remote

import com.example.weatherapp.model.WeatherData

data class WeatherApiResponse(
    var data: List<WeatherData>? = null
)