package com.example.weatherapp

import com.example.weatherapp.model.WeatherDataSource
import com.example.weatherapp.model.WeatherRepository
import com.example.weatherapp.model.remote.WeatherAPIDataSource
import com.example.weatherapp.model.remote.WeatherApi
import com.example.weatherapp.viewmodel.WeatherViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val WeatherModule = module {
    single { Retrofit.Builder().baseUrl("https://www.mocky.io").addConverterFactory(
        GsonConverterFactory.create()).build() }
    single { (get() as Retrofit).create(WeatherApi::class.java) }

    single(named("api")){ WeatherAPIDataSource(get())  as WeatherDataSource }
    single(named("repository")) { WeatherRepository(get(named("api"))) as WeatherDataSource }
    viewModel { WeatherViewModel(get(named("repository")), androidApplication()) }
}


/**
 * Module list
 */
val weatherModule = listOf(WeatherModule)