package com.example.parkeerautomatenv4.ui.parkeerautomaat_favorites

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.FavoriteEntity
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import com.example.parkeerautomatenv4.utils.Resource

class ParkeerautomaatFavoritesViewModel(private val repository: ParkeerautomaatRepository, val activity: FragmentActivity) : ViewModel() {
    private lateinit var _parkeerautomaten: LiveData<Resource<List<ParkeerautomaatAndFields>>>
    val Parkeerautomaten: LiveData<Resource<List<ParkeerautomaatAndFields>>>
        get() = _parkeerautomaten

    private lateinit var _favorits: LiveData<List<FavoriteEntity>>
    val Favorits: LiveData<List<FavoriteEntity>>
        get() = _favorits

    fun updateFavorit() {
        try {
            _favorits = repository.getAllFavorit()
        } catch (e: Exception) {
            Toast.makeText(activity, "it fucin crashed m8", Toast.LENGTH_LONG).show()
        }
    }

    fun updateParkeerautomaten() {
        try {
            _parkeerautomaten = repository.getParkeerautomaten()
        } catch (e: Exception) {
            Toast.makeText(activity, "it fucin crashed m8", Toast.LENGTH_LONG).show()
        }
    }
}
