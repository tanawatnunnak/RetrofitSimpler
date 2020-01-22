package com.example.retrofitsimpler

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>
}