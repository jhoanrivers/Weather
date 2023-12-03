package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privytest.databinding.FragmentSnowBinding
import com.example.privytest.weatherpage.WeatherViewModel
import com.example.privytest.weatherpage.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SnowFragment : Fragment() {



    lateinit var wViewModel: WeatherViewModel
    lateinit var binding : FragmentSnowBinding
    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSnowBinding.inflate(inflater, container, false)
        weatherAdapter = WeatherAdapter()
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
        binding.rvSnow.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
    }

    private fun bindViewModel() {

        wViewModel.rainWeather.observe(viewLifecycleOwner){
            weatherAdapter.updateAdapter(it.values.toList())
        }

    }

}