package com.example.weatherapp.model.remote

import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.WeatherDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class WeatherAPIDataSource(private val api: WeatherApi): WeatherDataSource {
    override fun fetchWeatherData(success: (List<WeatherData>) -> Unit, failure: () -> Unit) {
        val call = api.listWeatherData()
        call.enqueue(object : Callback<WeatherApiResponse> {

            override fun onResponse(call: Call<WeatherApiResponse>, response: Response<WeatherApiResponse>) {
                if (response.isSuccessful) {
                    val weatherList = mutableListOf<WeatherData>()
                    response.body()?.data?.forEach {
                        weatherList.add(it)
                    }
                    success(weatherList)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<WeatherApiResponse>, t: Throwable?) {
                failure()
            }
        })
    }
}