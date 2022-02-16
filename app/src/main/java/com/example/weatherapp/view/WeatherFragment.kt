package com.example.weatherapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.viewmodel.WeatherAdapter
import com.example.weatherapp.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R


class WeatherFragment: Fragment(), WeatherAdapter.ItemClickListener {
    private val vm: WeatherViewModel by viewModel()

    override fun onStart() {
        super.onStart()
        Log.i("Weather Fragment", "3984290384239 loading view model")
        vm.load()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<WeatherFragmentBinding>(inflater, com.example.weatherapp.R.layout.weather_fragment, container, false)
        binding.lifecycleOwner = this;
        binding.viewModel = vm
        binding.recyclerView.adapter = WeatherAdapter(emptyList(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(): WeatherFragment = WeatherFragment()
    }

    override fun onClick(weatherData: WeatherData) {
        val bundle = Bundle()
        bundle.putParcelable("data", weatherData)
        this.findNavController().navigate(R.id.action_weatherFragment_to_weatherDetailFragment, bundle)
    }
}