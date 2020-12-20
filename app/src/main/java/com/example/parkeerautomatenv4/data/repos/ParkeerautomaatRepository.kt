package com.example.parkeerautomatenv4.data.repos

import androidx.lifecycle.LiveData
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatLocalDataSource
import com.example.parkeerautomatenv4.data.remote.ParkeerautomaatRemoteDataSource
import com.example.parkeerautomatenv4.utils.Resource
import com.example.parkeerautomatenv4.utils.performGetOperation

class ParkeerautomaatRepository(
    private val parkeerautomaatLocalDataSource: ParkeerautomaatLocalDataSource,
    private val parkeerautomaatRemoteDataSource: ParkeerautomaatRemoteDataSource

) {

    fun getParkeerautomaat(id: String) = parkeerautomaatLocalDataSource.getParkeerautomaatById(id)



    fun getParkeerautomaten() = performGetOperation(

                databaseQuery = { parkeerautomaatLocalDataSource.getParkeerautomaten() },
                networkCall = { parkeerautomaatRemoteDataSource.getParkeerautomaten() },
                saveCallResult = {parkeerautomaatLocalDataSource.saveParkeerautomaat(it.records)}
    )


    fun getFavorit(id: String) = parkeerautomaatLocalDataSource.getFavorite(id)

    fun addFavorit(id: String) = parkeerautomaatLocalDataSource.addFavorite(id)

    fun deleteFavorit(id: String) = parkeerautomaatLocalDataSource.deleteFavorite(id)
}