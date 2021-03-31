package com.haithamghanem.androidtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.haithamghanem.androidtask.databinding.ActivityMainBinding
import com.haithamghanem.androidtask.model.Item
import com.haithamghanem.androidtask.view.ItemAdapter
import com.haithamghanem.androidtask.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var itemViewModel: ItemViewModel
    private var itemList: List<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        getRemoteDataSource()
        initComponents()
    }

    private fun initComponents() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getRemoteDataSource() {
        itemViewModel.getRemoteDataSource().observe(this, Observer {
            Log.d("TAG", "getRemoteDataSource: $it")
            itemList = listOf(it)
            adapter.setList(itemList)
        })
    }
}