package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privytest.R
import com.example.privytest.databinding.FragmentCloudsBinding
import com.example.privytest.databinding.FragmentRainBinding
import com.example.privytest.weatherpage.WeatherViewModel
import com.example.privytest.weatherpage.adapter.WeatherAdapter

class CloudsFragment : Fragment() {


    lateinit var wViewModel: WeatherViewModel
    lateinit var binding : FragmentCloudsBinding
    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCloudsBinding.inflate(inflater, container, false)
        val view = binding.root
        weatherAdapter = WeatherAdapter()

        initViewModel()
        bindViewModel()
        initView()

        return view
    }


    private fun initViewModel(){
        wViewModel = ViewModelProvider(requireActivity())[WeatherViewModel::class.java]
    }

    private fun initView() {
        binding.rvClouds.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
    }

    private fun bindViewModel() {

        wViewModel.cloudsWeather.observe(viewLifecycleOwner){
            weatherAdapter.updateAdapter(it.values.toList())
        }

    }


}