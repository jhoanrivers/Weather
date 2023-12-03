package com.example.privytest.weatherpage.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.privytest.databinding.ItemWeatherBinding
import com.example.privytest.weatherpage.model.WeatherModel

class WeatherAdapter() : RecyclerView.Adapter<WeatherAdapter.ViewHolder>(){


    var listWeather: List<WeatherModel> = mutableListOf()

    val degreesSymbol = "\u00B0"

    open fun updateAdapter(listWeather: List<WeatherModel>){
        this.listWeather = listWeather
        notifyDataSetChanged()
    }


    class ViewHolder (private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(weather: WeatherModel) {
            binding.tvCount.text = weather.count.toString()
            binding.tvCity.text = weather.cityName
            binding.maxTemp.text = weather.maxTemp
            binding.tvMinTemp.text = weather.minTemp
            binding.tvCurrentTemp.text = weather.currentTemp

            Glide.with(binding.imgIcon.context)
                .load(Uri.parse("https://openweathermap.org/img/wn/${weather.icon}@4x.png"))
                .into(binding.imgIcon)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listWeather.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listWeather[position]
        holder.bind(currentItem)
    }
}