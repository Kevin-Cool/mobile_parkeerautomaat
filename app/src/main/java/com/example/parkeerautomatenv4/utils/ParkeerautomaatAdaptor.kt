package com.example.parkeerautomatenv4.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.databinding.ListItemParkeerautomaatBinding

class ParkeerautomaatAdaptor(private var parkeerautomaatClickListener: ParkeerautomaatClickListener) : ListAdapter<ParkeerautomaatAndFields,ParkeerautomaatViewHolder>(ParkingDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkeerautomaatViewHolder {
        return ParkeerautomaatViewHolder(ListItemParkeerautomaatBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ParkeerautomaatViewHolder, position: Int) {
        val parkeerautomaat = getItem(position)
        holder.bindData(parkeerautomaat)
        holder.itemView.setOnClickListener{
            parkeerautomaatClickListener.ParkeerautmaatClicked(parkeerautomaat)
        }
    }
}

private class ParkingDiffCallback: DiffUtil.ItemCallback<ParkeerautomaatAndFields>(){
    override fun areItemsTheSame(oldItem: ParkeerautomaatAndFields, newItem: ParkeerautomaatAndFields): Boolean {
        return  oldItem.parkeerautomaat.recordid == newItem.parkeerautomaat.recordid
    }

    override fun areContentsTheSame(oldItem: ParkeerautomaatAndFields, newItem: ParkeerautomaatAndFields): Boolean {
        return oldItem.parkeerautomaat.equals(newItem.parkeerautomaat)
    }

}

class ParkeerautomaatViewHolder(val binding: ListItemParkeerautomaatBinding) : RecyclerView.ViewHolder(binding.root){

    fun bindData(parkeerautomaatAndFields: ParkeerautomaatAndFields){
        binding.parkeerautomaat = parkeerautomaatAndFields
    }
}

interface ParkeerautomaatClickListener{
    fun ParkeerautmaatClicked(parkeerautomaatAndFields: ParkeerautomaatAndFields)
}

