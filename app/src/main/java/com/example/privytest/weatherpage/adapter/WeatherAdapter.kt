package com.example.privytest.weatherpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.privytest.databinding.ItemWeatherBinding
import com.example.privytest.weatherpage.model.WeatherModel

class WeatherAdapter(private val listWeather: List<WeatherModel>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>(){


    class ViewHolder (private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(weather: WeatherModel) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}