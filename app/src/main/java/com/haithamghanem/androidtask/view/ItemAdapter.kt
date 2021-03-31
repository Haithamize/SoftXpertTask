package com.haithamghanem.androidtask.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haithamghanem.androidtask.R
import com.haithamghanem.androidtask.databinding.ItemBinding
import com.haithamghanem.androidtask.model.Item

class ItemAdapter(private val context:Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var items: List<Item> = ArrayList()
    private lateinit var bindingAdapter: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        bindingAdapter = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item, parent, false);

        return ItemViewHolder(
            bindingAdapter
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if(items.isEmpty()){
            return
        }
        var path:String = items[position].imageUrl;

        holder.brand.text = items[position].brand
        holder.year.text = items[position].constructionYear
        holder.isUsed.text = items[position].isUsed.toString()
        holder.image?.let {
            Glide.with(it)
                .load(path)
                .into(it)
        }



}

    override fun getItemCount(): Int = items.size


    class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        val image = binding.image
        val isUsed = binding.isUsed
        val year = binding.constructionYear
        val brand = binding.brand
    }

    fun setList(itemList: List<Item>){
        items = itemList
        notifyDataSetChanged()
    }
}