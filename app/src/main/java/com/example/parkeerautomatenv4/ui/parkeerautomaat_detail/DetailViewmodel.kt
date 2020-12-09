package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class DetailViewmodel() : ViewModel() {
    private var _parkeerautomaat = MutableLiveData<Parkeerautomaat>()
    val parkeerautomaat : LiveData<Parkeerautomaat>
    get() = _parkeerautomaat

    fun updateParkeerautomaat(parkeerautomaat: Parkeerautomaat){
        _parkeerautomaat.value = parkeerautomaat
    }

}