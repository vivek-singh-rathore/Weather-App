package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData (
    val temp: String,
    val time: String,
    val rain: String,
    val wind: String
) : Parcelable