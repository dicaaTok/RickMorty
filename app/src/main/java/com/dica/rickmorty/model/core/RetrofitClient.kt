package com.dica.rickmorty.model.core

import com.dica.rickmorty.model.service.CharacterService
import com.dica.rickmorty.model.service.WeatherService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object RetrofitClient {

    //private const val BASE_URl = "https://api.weatherapi.com/v1/"
    private const val BASE_URl = "https://rickandmortyapi.com/api/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient= true
    }

    internal val retrofitService: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URl)
            .client(httpClient)
            .addConverterFactory(Json.asConverterFactory("*/*".toMediaType()))
            .build()

    }
    val characterService : CharacterService by lazy {
        retrofitService.create(CharacterService::class.java)
    }

    val weatherService: WeatherService by lazy {
        retrofitService.create(WeatherService::class.java)
    }

}