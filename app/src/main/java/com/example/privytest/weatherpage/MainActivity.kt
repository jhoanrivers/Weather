package com.example.privytest.weatherpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.privytest.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var viewModel: WeatherViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        initViews()

    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    private fun initViews() {
        viewModel.getRandomDogs()
    }

}