package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.api.Parkeerautomaat

class DetailViewmodel() : ViewModel() {
    lateinit var Parkeerautomaat : Parkeerautomaat

    fun set(parkeer : Parkeerautomaat){
        this.Parkeerautomaat = parkeer
    }
}