package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parkeerautomatenv4.data.remote.GhentApiService
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import java.lang.IllegalArgumentException

class ParkeerautomaatLijstViewModelFactory (val activity: FragmentActivity, private val repository: ParkeerautomaatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParkeerautomaatLijstViewModel::class.java)){
            return ParkeerautomaatLijstViewModel(repository,activity) as T
        }
        throw IllegalArgumentException("Unkown Viewmodel class")
    }

}