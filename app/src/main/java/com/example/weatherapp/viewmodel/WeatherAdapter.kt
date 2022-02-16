package com.example.weatherapp.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeatherItemBinding
import com.example.weatherapp.model.WeatherData


class WeatherAdapter(var items: List<WeatherData>, val itemClickListener: ItemClickListener) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: WeatherItemBinding = WeatherItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun updateItems(items: List<WeatherData>?) {
        this.items = items ?: emptyList()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

     inner class ViewHolder(val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherData: WeatherData) {
            binding.weather = weatherData
            binding.itemClickListener = itemClickListener
            binding.executePendingBindings();

        }
    }

    public interface ItemClickListener {
        fun onClick(weatherData: WeatherData)
    }
}