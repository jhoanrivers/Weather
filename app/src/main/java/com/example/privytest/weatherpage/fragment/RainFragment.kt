package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.privytest.R
import com.example.privytest.databinding.FragmentRainBinding
import com.example.privytest.weatherpage.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RainFragment : Fragment() {


    lateinit var viewModel: WeatherViewModel
    lateinit var binding : FragmentRainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRainBinding.inflate(inflater, container, false)

        val view = binding.root
        initViewModel()
        initView()
        bindViewModel()
        return view
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    private fun initView() {
        binding.rvRain.apply {

        }
    }

    private fun bindViewModel() {
        viewModel.rainWeather.observe(viewLifecycleOwner){

        }

    }

}