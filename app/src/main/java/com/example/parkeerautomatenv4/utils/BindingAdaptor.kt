package com.example.parkeerautomatenv4.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["setAdaptor"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>){
    this.run {
        this.adapter = adapter
    }
}