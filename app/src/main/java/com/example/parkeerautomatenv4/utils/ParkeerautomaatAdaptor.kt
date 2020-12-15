package com.example.parkeerautomatenv4.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFieldsAndGeometry
import com.example.parkeerautomatenv4.databinding.ListItemParkeerautomaatBinding
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class ParkeerautomaatAdaptor(private var parkeerautomaatClickListener: ParkeerautomaatClickListener) : ListAdapter<ParkeerautomaatAndFieldsAndGeometry,ParkeerautomaatViewHolder>(ParkingDiffCallback()){
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

private class ParkingDiffCallback: DiffUtil.ItemCallback<ParkeerautomaatAndFieldsAndGeometry>(){
    override fun areItemsTheSame(oldItem: ParkeerautomaatAndFieldsAndGeometry, newItem: ParkeerautomaatAndFieldsAndGeometry): Boolean {
        return  oldItem.parkeerautomaat.recordid == newItem.parkeerautomaat.recordid
    }

    override fun areContentsTheSame(oldItem: ParkeerautomaatAndFieldsAndGeometry, newItem: ParkeerautomaatAndFieldsAndGeometry): Boolean {
        return oldItem == newItem
    }

}

class ParkeerautomaatViewHolder(val binding: ListItemParkeerautomaatBinding) : RecyclerView.ViewHolder(binding.root){

    fun bindData(parkeerautomaatAndFieldsAndGeometry: ParkeerautomaatAndFieldsAndGeometry){
        binding.parkeerautomaat = parkeerautomaatAndFieldsAndGeometry
    }
}

interface ParkeerautomaatClickListener{
    fun ParkeerautmaatClicked(parkeerautomaatAndFieldsAndGeometry: ParkeerautomaatAndFieldsAndGeometry)
}

