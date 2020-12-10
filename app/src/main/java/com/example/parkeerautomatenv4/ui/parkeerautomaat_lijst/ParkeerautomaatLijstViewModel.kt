package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkeerautomatenv4.data.remote.GhentApiService
import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import kotlinx.coroutines.launch
import kotlin.math.log

class ParkeerautomaatLijstViewModel(private val apiService: GhentApiService) : ViewModel() {
    private val _parkeerautomaten = MutableLiveData<List<Parkeerautomaat>>()
    val parkeerautomaten: LiveData<List<Parkeerautomaat>>
        get() = _parkeerautomaten

    init {
        getParkeerautomaatFromApiService()
    }


   private fun getParkeerautomaatFromApiService(){

       viewModelScope.launch {
           try {
               val response = apiService.getParkeerautomaten()
               _parkeerautomaten.value = response.records
           }
           catch(e:Exception){
               Log.e("Error api",e.message,e)
           }
       }
    }
}