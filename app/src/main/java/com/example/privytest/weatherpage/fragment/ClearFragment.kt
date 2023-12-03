package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.privytest.R
import com.example.privytest.weatherpage.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClearFragment : Fragment() {


    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_clear, container, false)

        initViewModel()
        bindViewModel()

        return view
    }

    private fun bindViewModel() {
        viewModel.clearWeather.observe(viewLifecycleOwner){

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
    }

}