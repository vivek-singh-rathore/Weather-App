package com.example.weatherapp.model

interface WeatherDataSource {
    fun fetchWeatherData(success: (List<WeatherData>) -> Unit, failure: () -> Unit)
}