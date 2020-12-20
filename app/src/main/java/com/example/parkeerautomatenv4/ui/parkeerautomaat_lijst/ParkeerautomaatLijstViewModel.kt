package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.remote.GhentApiService
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import com.example.parkeerautomatenv4.utils.Resource
import kotlinx.coroutines.launch
import kotlin.math.log

class ParkeerautomaatLijstViewModel(private val repository: ParkeerautomaatRepository,val activity: FragmentActivity) : ViewModel() {
    private lateinit var _parkeerautomaten : LiveData<Resource<List<ParkeerautomaatAndFields>>>
    val parkeerautomaten : LiveData<Resource<List<ParkeerautomaatAndFields>>>
        get() = _parkeerautomaten

    fun updateParkeerautomaten(){
        try {
            _parkeerautomaten = repository.getParkeerautomaten()
        }catch (e: Exception){
            Toast.makeText(activity , "it fucin crashed m8", Toast.LENGTH_LONG).show()
        }
    }


}