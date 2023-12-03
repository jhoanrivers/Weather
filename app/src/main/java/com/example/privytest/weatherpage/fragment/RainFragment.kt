package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privytest.databinding.FragmentWeatherBinding
import com.example.privytest.weatherpage.ViewPagerAdapter
import com.example.privytest.weatherpage.WeatherViewModel
import com.example.privytest.weatherpage.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RainFragment : Fragment() {


    lateinit var wViewModel: WeatherViewModel
    lateinit var binding : FragmentWeatherBinding
    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        weatherAdapter = WeatherAdapter(requireContext())
        val view = binding.root
        initViewModel()
        bindViewModel()
        initView()
        return view
    }
    private fun initViewModel(){
        wViewModel = ViewModelProvider(requireActivity())[WeatherViewModel::class.java]
    }

    private fun initView() {
        binding.rvWeather.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
    }

    private fun bindViewModel() {

        wViewModel.rainWeather.observe(viewLifecycleOwner){
            weatherAdapter.updateAdapter(it.values.toList())
        }

        wViewModel.loadingData.observe(viewLifecycleOwner) {
            if (it) {
                binding.pbWeather.visibility = View.VISIBLE
                binding.rvWeather.visibility = View.GONE
            } else {
                binding.pbWeather.visibility = View.GONE
                binding.rvWeather.visibility = View.VISIBLE
            }
        }

    }

}