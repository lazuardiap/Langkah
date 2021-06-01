package com.newshelter.langkah.utils.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_MAIN = "https://maps.googleapis.com/"

    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_MAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}