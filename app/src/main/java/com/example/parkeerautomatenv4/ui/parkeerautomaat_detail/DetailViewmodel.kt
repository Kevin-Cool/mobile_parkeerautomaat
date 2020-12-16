package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository

class DetailViewModel(private val repository: ParkeerautomaatRepository) : ViewModel() {
    private lateinit var _parkeerautomaat : LiveData<ParkeerautomaatAndFields>
    val parkeerautomaat : LiveData<ParkeerautomaatAndFields>
    get() = _parkeerautomaat

    fun updateParkeerautomaat(id: String){
        _parkeerautomaat = repository.getParkeerautomaat(id)
    }

}