package com.dica.weathermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dica.rickmorty.model.models.WeatherResponse
import com.dica.rickmorty.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val repository = WeatherRepository()

    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse : LiveData<WeatherResponse> = _weatherResponse

    fun getWeather(location : String) {
        viewModelScope.launch {
            try {


                val weather = repository.getWeather(location = location)
                _weatherResponse.postValue(weather)
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
    }
}