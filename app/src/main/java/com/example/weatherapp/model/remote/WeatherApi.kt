package com.example.weatherapp.model.remote

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    @GET("/v2/5d3a99ed2f0000bac16ec13a")
    fun listWeatherData(): Call<WeatherApiResponse>
}