package com.haithamghanem.androidtask.repo

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.haithamghanem.androidtask.data.remote.RetrofitClient
import com.haithamghanem.androidtask.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository {

    val mutableList = MutableLiveData<Item>()

    fun getRemoteDataSource(): MutableLiveData<Item> {

        GlobalScope.launch {
            Dispatchers.IO
            try {
                val response = RetrofitClient.getApiService()
                        .getItems(1).execute()


                withContext(Dispatchers.Main) {
                    if (response.isSuccessful)
                        mutableList.value = response.body()
                }

            } catch (e: Exception) {
                Log.i("TAG", "getDataApi: " + e.message)
            }
        }

        return mutableList
    }
}