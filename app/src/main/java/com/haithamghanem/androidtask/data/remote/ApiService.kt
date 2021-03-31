package com.haithamghanem.androidtask.data.remote

import com.haithamghanem.androidtask.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/cars")
    fun getItems(@Query("page") page: Int): Call<Item>

}