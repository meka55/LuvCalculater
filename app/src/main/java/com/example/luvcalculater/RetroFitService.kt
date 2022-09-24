package com.example.luvcalculater

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroFitService {
    private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    val api = retrofit.create<LuvApi>()
}