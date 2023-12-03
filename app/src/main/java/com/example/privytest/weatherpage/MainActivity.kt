package com.example.privytest.weatherpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.privytest.R
import com.example.privytest.databinding.ActivityMainBinding
import com.example.privytest.weatherpage.fragment.ClearFragment
import com.example.privytest.weatherpage.fragment.CloudsFragment
import com.example.privytest.weatherpage.fragment.RainFragment
import com.example.privytest.weatherpage.fragment.SnowFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var viewModel: WeatherViewModel
    lateinit var binding: ActivityMainBinding

    private val fragments : List<Fragment> = listOf(
        ClearFragment(),
        CloudsFragment(),
        RainFragment(),
        SnowFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        initViews()

    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    private fun initViews() {

        val adapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
           when(position) {
               0 -> tab.text = "Clear"
               1 -> tab.text = "Coulds"
               2 -> tab.text = "Rain"
               3 -> tab.text = "Snow"
           }
        }.attach()

        viewModel.getForecastWeather()
    }

}