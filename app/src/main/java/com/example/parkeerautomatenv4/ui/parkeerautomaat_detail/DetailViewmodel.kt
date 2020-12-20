package com.example.parkeerautomatenv4.ui.parkeerautomaat_detail

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.FavoriteEntity
import com.example.parkeerautomatenv4.data.repos.ParkeerautomaatRepository
import androidx.lifecycle.Observer
import java.security.acl.Owner

class DetailViewModel(private val repository: ParkeerautomaatRepository,val activity: FragmentActivity) : ViewModel() {
    private lateinit var _parkeerautomaat : LiveData<ParkeerautomaatAndFields>
    val parkeerautomaat : LiveData<ParkeerautomaatAndFields>
    get() = _parkeerautomaat

    private lateinit var _isFavorit : LiveData<FavoriteEntity>
    val isFavorit : LiveData<FavoriteEntity>
        get() = _isFavorit



    fun updateFavorit(id: String){
        _isFavorit = repository.getFavorit(id)
    }

    fun updateParkeerautomaat(id: String){
        _parkeerautomaat = repository.getParkeerautomaat(id)
    }

    fun update(){
        val id : String = _parkeerautomaat.value?.records?.recordid!!
        if(isFavorit.value != null ){
            repository.deleteFavorit(id)
            Toast.makeText(activity , "Removed from favorite", Toast.LENGTH_LONG).show()
        }else{
            repository.addFavorit(id)
            Toast.makeText(activity , "Added to favorite", Toast.LENGTH_LONG).show()
        }
    }
}