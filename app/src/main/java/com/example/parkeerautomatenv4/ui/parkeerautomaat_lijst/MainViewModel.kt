package com.example.parkeerautomatenv4.ui.parkeerautomaat_lijst

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkeerautomatenv4.api.parkeerautomaatApi
import com.example.parkeerautomatenv4.api.parkeerautomaten
import kotlinx.coroutines.launch

enum class OverViewStatus{ERROR, LOADING,DONE}
class MainViewModel : ViewModel() {
    private val parkeerautomaten = MutableLiveData<parkeerautomaten>()
    val properties: LiveData<parkeerautomaten>
        get() = parkeerautomaten


    var status = MutableLiveData<OverViewStatus>()
    init {
        status.value = OverViewStatus.DONE
        get_parkeerautomaat_from_api()
    }
    fun get_parkeerautomaat_from_api()
    {
        status.value = OverViewStatus.LOADING
        viewModelScope.launch {
            try {
                val result  = parkeerautomaatApi.retrofitService.getparkeerautomaten()
                parkeerautomaten.postValue(result)
                status.value = OverViewStatus.DONE
            }
            catch(e:Exception){
                Log.e("ERROR", e.message, e)
                status.value = OverViewStatus.ERROR
            }
        }
    }
}