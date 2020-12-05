package com.example.parkeerautomatenv4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parkeerautomatenv4.api.Parkeerautomaat
import com.example.parkeerautomatenv4.databinding.ParkeerautomaatItemViewBinding


class parkeerautomaat_adaptor(private  val parkeerautomaatClicklistener: parkeerautomaat_clicklistener) : ListAdapter<Parkeerautomaat, parkeerautomaat_adaptor.CustomparkeerautomaatHolder>(parkeerautomaat_callback()){
    override fun onCreateViewHolder (
            parent: ViewGroup,
            viewType: Int
    ): CustomparkeerautomaatHolder{
        return CustomparkeerautomaatHolder.from(parent, parkeerautomaatClicklistener)

    }

    override fun onBindViewHolder(holder: parkeerautomaat_adaptor.CustomparkeerautomaatHolder, position: Int) = holder.bind(getItem(position))

    class CustomparkeerautomaatHolder (val binding : ParkeerautomaatItemViewBinding, gameClicklistener: parkeerautomaat_clicklistener) : RecyclerView.ViewHolder(binding.root){
        init {

            binding.setClickListener {
                binding.parkeerautomaat?.let {
                    parkeerautomaat ->    gameClicklistener.onGameClicklistener(parkeerautomaat)
                }

            }
        }


        fun bind(parkeerautomaten: Parkeerautomaat){
            binding.apply {
                binding.parkeerautomaat = parkeerautomaten;
                binding.executePendingBindings()
            }
        }
        companion object{
            fun from(parent: ViewGroup, gameClicklistener: parkeerautomaat_clicklistener): CustomparkeerautomaatHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ParkeerautomaatItemViewBinding.inflate(layoutInflater, parent, false)
                return CustomparkeerautomaatHolder(binding, gameClicklistener);
            }
        }
    }

    class parkeerautomaat_callback : DiffUtil.ItemCallback<Parkeerautomaat>(){

        override fun areItemsTheSame(oldItem: Parkeerautomaat, newItem: Parkeerautomaat): Boolean{
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Parkeerautomaat, newItem: Parkeerautomaat): Boolean {
            return oldItem == newItem
        }


    }

}