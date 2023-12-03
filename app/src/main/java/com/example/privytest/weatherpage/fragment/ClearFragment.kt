package com.example.privytest.weatherpage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.privytest.R
import com.example.privytest.databinding.FragmentClearBinding
import com.example.privytest.weatherpage.WeatherViewModel
import com.example.privytest.weatherpage.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClearFragment : Fragment() {


    lateinit var viewModel: WeatherViewModel
    lateinit var binding: FragmentClearBinding
    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentClearBinding.inflate(inflater, container, false)
        weatherAdapter = WeatherAdapter()
        val view = binding.root

        initViewModel()
        bindViewModel()
        initView()
        return view
    }

    private fun bindViewModel() {
        viewModel.clearWeather.observe(viewLifecycleOwner){
            weatherAdapter.updateAdapter(it.values.toList())
        }
    }

    private fun initView() {
        binding.rvClear.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = null
        }
    }


    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[WeatherViewModel::class.java]
    }

}