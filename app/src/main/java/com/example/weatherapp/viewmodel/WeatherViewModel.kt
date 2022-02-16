package com.example.weatherapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.Utils
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.WeatherDataSource
import com.example.weatherapp.model.WeatherRepository

class WeatherViewModel(private val repository: WeatherDataSource, private val application: Application) : ViewModel() {

    var weatherData = MutableLiveData<MutableList<WeatherData>>(mutableListOf())

    fun load() {
        repository.fetchWeatherData({ items ->
            run {
                val utils = Utils()
                val transformedItems = items.map {utils.transformWeatherData(it)}
                weatherData.postValue(transformedItems.toMutableList())
            }
        }, {
            Log.i("Weather View Model", "Error in fetching weather data")
        })
    }
}