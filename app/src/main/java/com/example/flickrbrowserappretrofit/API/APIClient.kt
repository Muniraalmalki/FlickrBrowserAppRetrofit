package com.example.flickrbrowserappretrofit.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    private var retrofit : Retrofit? = null
    fun getClient(): Retrofit?{
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}