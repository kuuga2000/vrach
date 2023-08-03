package com.example.vrach.network.customer

import com.example.vrach.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CustomerInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CustomerApiService by lazy {
        retrofit.create(CustomerApiService::class.java)
    }
}