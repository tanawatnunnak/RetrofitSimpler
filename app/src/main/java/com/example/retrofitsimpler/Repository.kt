package com.example.retrofitsimpler

import com.example.mushroom.data.direction.NetworkCall

class Repository(private val apiService: ApiService) {
    fun getUser(user: String) = NetworkCall<User>().makeCall(apiService.getUser(user))
}