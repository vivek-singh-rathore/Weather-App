package com.example.weatherapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class WeatherApp : Application(){

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@WeatherApp)
            modules(weatherModule)
        }
    }
}