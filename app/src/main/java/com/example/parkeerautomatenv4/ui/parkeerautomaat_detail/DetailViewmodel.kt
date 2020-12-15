package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFieldsAndGeometry
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class DetailViewModel(private val repository: ParkeerautomaatRepository) : ViewModel() {
    private lateinit var _parkeerautomaat : LiveData<ParkeerautomaatAndFieldsAndGeometry>
    val parkeerautomaat : LiveData<ParkeerautomaatAndFieldsAndGeometry>
    get() = _parkeerautomaat

    fun updateParkeerautomaat(id: String){
        _parkeerautomaat = repository.getParkeerautomaat(id)
    }

}