package com.example.parkeerautomatenv4.ui.parkeerautomaat_favorites

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import java.lang.IllegalArgumentException

class ParkeerautomaatFavoritesViewModelFactory(val activity: FragmentActivity, private val repository: ParkeerautomaatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParkeerautomaatFavoritesViewModel::class.java)) {
            return ParkeerautomaatFavoritesViewModel(repository, activity) as T
        }
        throw IllegalArgumentException("Unkown Viewmodel class")
    }
}
