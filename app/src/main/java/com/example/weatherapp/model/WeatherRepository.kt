package com.example.weatherapp.model

class WeatherRepository(private val remoteWeatherDataSource: WeatherDataSource): WeatherDataSource {
    override fun fetchWeatherData(success: (List<WeatherData>) -> Unit, failure: () -> Unit) {
        remoteWeatherDataSource.fetchWeatherData(success, failure)
    }
}