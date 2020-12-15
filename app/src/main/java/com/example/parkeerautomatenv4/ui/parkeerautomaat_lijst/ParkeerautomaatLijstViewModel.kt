package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkeerautomatenv4.data.remote.GhentApiService
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import kotlinx.coroutines.launch
import kotlin.math.log

class ParkeerautomaatLijstViewModel(repository: ParkeerautomaatRepository) : ViewModel() {
    val parkeerautomaten = repository.getParkeerautomaten()
}