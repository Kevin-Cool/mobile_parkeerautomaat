package com.example.parkeerautomatenv4.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.parkeerautomatenv4.databinding.ListItemParkeerautomaatBinding
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class ParkeerautomaatAdaptor : ListAdapter<Parkeerautomaat,ParkeerautomaatViewHolder>(ParkingDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkeerautomaatViewHolder {
        return ParkeerautomaatViewHolder(ListItemParkeerautomaatBinding.inflate(LayoutInflater.from(parent.context),parent))
    }

    override fun onBindViewHolder(holder: ParkeerautomaatViewHolder, position: Int) {
        val parkeerautomaat = getItem(position)
        holder.bindData(parkeerautomaat)
    }


}

private class ParkingDiffCallback: DiffUtil.ItemCallback<Parkeerautomaat>(){
    override fun areItemsTheSame(oldItem: Parkeerautomaat, newItem: Parkeerautomaat): Boolean {
        return  oldItem.recordid == newItem.recordid
    }

    override fun areContentsTheSame(oldItem: Parkeerautomaat, newItem: Parkeerautomaat): Boolean {
        return oldItem == newItem
    }

}

class ParkeerautomaatViewHolder(val binding: ListItemParkeerautomaatBinding) : RecyclerView.ViewHolder(binding.root){

    fun bindData(parkeerautomaat: Parkeerautomaat){
        binding.parkeerautomaat = parkeerautomaat
    }
}