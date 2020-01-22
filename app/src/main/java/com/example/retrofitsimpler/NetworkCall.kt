package com.example.mushroom.data.direction

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofitsimpler.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


open class NetworkCall<T> {
    private lateinit var call: Call<T>

    fun makeCall(call: Call<T>): MutableLiveData<Result<T>> {
        this.call = call
        val callBackKt = CallBackKt<T>()
        this.call.clone().enqueue(callBackKt)
        return callBackKt.result
    }

    class CallBackKt<T> : Callback<T> {
        var result: MutableLiveData<Result<T>> = MutableLiveData()
        override fun onFailure(call: Call<T>, t: Throwable) {
            result.value = Result.error(t.message!!)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful)
                result.value = Result.success(response.body()!!)
            else
                result.value = Result.error(response.errorBody().toString())
        }
    }

    fun cancel() {
        if (::call.isInitialized)
            call.cancel()
    }
}