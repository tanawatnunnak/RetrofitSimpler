package com.example.retrofitsimpler

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var instance: Retrofit? = null
    private fun getRetrofit(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

    fun build(): ApiService = this.getRetrofit().create(ApiService::class.java)
}