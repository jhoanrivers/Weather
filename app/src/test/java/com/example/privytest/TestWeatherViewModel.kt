package com.example.privytest

import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.privytest.data.entity.*
import com.example.privytest.di.network.NetworkResult
import com.example.privytest.repository.Repository
import com.example.privytest.weatherpage.WeatherViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import javax.inject.Inject


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class TestWeatherViewModel {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    lateinit var viewModel : WeatherViewModel

    @Mock
    lateinit var repository: Repository


    @Mock
    lateinit var preference: SharedPreferences

    private val testCoroutineDispatcher = TestCoroutineDispatcher()


    @Before
    fun setup() {
        viewModel = WeatherViewModel(repository, preference)
    }


    @After
    fun testDownDispatcher(){
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun `Fetch list of weather`() {

        //Mock data and behaviour
        val testData = WeatherResponse(
            cod = "200",
            message = 0,
            listWeather = listOf(
                WeatherEntity(
                    mainWeather = MainWeatherEntity(temp = 276.5, 275.5, 278.5),
                    dataWeather = listOf(
                        DataWeatherEntity(
                            main = "clouds",
                            icon = "10n"
                        )
                    )
                )
            ),
            city = CityEntity(
                id = 12354,
                name = "Indonesia"
            )
        )
        `when` (repository.sampleListWeather()).thenReturn(testData)


        val observer = mock(Observer::class.java) as Observer<WeatherResponse>
        viewModel.testListWeather.observeForever(observer)



        val result = viewModel.getSampleWeather()

        verify(repository).sampleListWeather()
        verify(observer).onChanged(testData)


        assertEquals("Indonesia", result.city.name)



        viewModel.testListWeather.removeObserver(observer)



    }



}