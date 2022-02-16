package com.example.weatherapp

import com.example.weatherapp.model.WeatherData
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    public fun transformWeatherData(weatherData: WeatherData): WeatherData {

        return WeatherData(
            weatherData.temp + "\u2103",
            convertTime(weatherData.time),
            weatherData.rain + "%",
            weatherData.wind + " km/h"
        )
    }

    private fun convertTime(unixTime: String): String {
        return try {
            val sdf = SimpleDateFormat("MMMM dd yyyy")
            val netDate = Date(unixTime.toLong() * 1000)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

}