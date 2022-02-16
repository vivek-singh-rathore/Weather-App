package com.example.weatherapp.view

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherDataBinding
import android.R.attr.defaultValue
import com.example.weatherapp.model.WeatherData


class WeatherDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<WeatherDataBinding>(inflater,
            R.layout.weather_data, container, false)


        val bundle = this.arguments
        if (bundle != null) {
            val weatherData: WeatherData? = bundle.getParcelable<WeatherData>("data")
            binding.weather = weatherData
        }

        return binding.root
    }
}