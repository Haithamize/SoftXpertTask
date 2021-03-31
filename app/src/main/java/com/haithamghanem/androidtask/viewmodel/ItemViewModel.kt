package com.haithamghanem.androidtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haithamghanem.androidtask.model.Item
import com.haithamghanem.androidtask.repo.Repository

class ItemViewModel: ViewModel() {
private val repo = Repository()


    fun getRemoteDataSource(): MutableLiveData<Item>{
        return repo.getRemoteDataSource()
    }


}