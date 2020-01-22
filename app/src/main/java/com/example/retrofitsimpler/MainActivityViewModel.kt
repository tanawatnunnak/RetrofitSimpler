package com.example.retrofitsimpler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.build()
    private val repository = Repository(apiService)
    fun getUser(user: String): MutableLiveData<Result<User>> = repository.getUser(user)
}