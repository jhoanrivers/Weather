package com.example.privytest.weatherpage.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.privytest.R
import com.example.privytest.Utils.Utils
import com.example.privytest.Utils.Utils.decimalFormat
import com.example.privytest.Utils.Utils.sortDescCountAscName
import com.example.privytest.databinding.ItemWeatherBinding
import com.example.privytest.weatherpage.model.WeatherModel
import com.squareup.picasso.Picasso

class WeatherAdapter(private val context: Context) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {


    var listWeather: List<WeatherModel> = mutableListOf()

    val degreesSymbol = "\u00B0"

    open fun updateAdapter(weathers: List<WeatherModel>) {
        val sortDescCount = sortDescCountAscName(weathers)
        this.listWeather = sortDescCount
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: WeatherModel) {
            binding.tvCount.text = weather.count.toString()
            binding.tvCity.text = weather.cityName
            binding.maxTemp.text = convertToCelsius(weather.maxTemp.toDouble())
            binding.tvMinTemp.text = convertToCelsius(weather.minTemp.toDouble())
            binding.tvCurrentTemp.text = convertToCelsius(weather.currentTemp.toDouble())


            val imageUri = "http://openweathermap.org/img/wn/${weather.icon}@2x.png"
            Glide.with(context).load(imageUri).into(binding.imgIcon)
        }

    }


    fun convertToCelsius(kelvin: Double): String {
        return "${decimalFormat.format(kelvin - 273.15)}$degreesSymbol C"
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