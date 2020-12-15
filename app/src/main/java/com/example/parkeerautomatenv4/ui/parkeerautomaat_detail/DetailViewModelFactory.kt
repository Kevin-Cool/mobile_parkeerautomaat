package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst.ParkeerautomaatLijstViewModel
import java.lang.IllegalArgumentException

class DetailViewModelFactory (private val repository: ParkeerautomaatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModelFactory::class.java)){
            return DetailViewModelFactory(repository) as T
        }
        throw IllegalArgumentException("Unkown Viewmodel class")
    }

}