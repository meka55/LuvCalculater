package com.example.luvcalculater

import android.app.Application

class App:Application() {
    companion object{
        lateinit var api : LuvApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService= RetroFitService()
        api = retrofitService.api
    }
}