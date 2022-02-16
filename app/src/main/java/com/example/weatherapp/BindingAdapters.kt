package com.example.weatherapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.viewmodel.WeatherAdapter

class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, items: MutableList<WeatherData>) {

            if (recyclerView.adapter != null && recyclerView.adapter is WeatherAdapter) {
                (recyclerView.adapter as WeatherAdapter).updateItems(items)
            }
        }
    }

}