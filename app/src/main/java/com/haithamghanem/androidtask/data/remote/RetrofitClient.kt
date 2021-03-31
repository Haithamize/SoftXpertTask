package com.haithamghanem.androidtask.data.remote

import com.haithamghanem.androidtask.model.Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {



    private fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://demo1286023.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    fun getApiService():ApiService{
        return getInstance().create(ApiService::class.java)
    }
}