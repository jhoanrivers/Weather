package com.example.privytest.weatherpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.privytest.R
import com.example.privytest.Utils.NetworkEnum
import com.example.privytest.databinding.ActivityMainBinding
import com.example.privytest.weatherpage.fragment.ClearFragment
import com.example.privytest.weatherpage.fragment.CloudsFragment
import com.example.privytest.weatherpage.fragment.RainFragment
import com.example.privytest.weatherpage.fragment.SnowFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel : WeatherViewModel by viewModels()
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
        initViews()
        bindViewModel()

    }

    private fun initViews() {
        val adapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
           when(position) {
               0 -> tab.text = "Clear"
               1 -> tab.text = "Clouds"
               2 -> tab.text = "Rain"
               3 -> tab.text = "Snow"
           }
        }.attach()

        viewModel.getForecastWeather()

    }


    private fun bindViewModel() {

        viewModel.listWeather.observe(this) {
            when (it.status) {
                NetworkEnum.SUCCESS -> println("Success")
                NetworkEnum.LOADING -> println("loading")
                NetworkEnum.ERROR -> println("error")
            }
        }

    }



}