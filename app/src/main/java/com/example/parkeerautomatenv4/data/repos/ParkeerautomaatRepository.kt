package com.example.parkeerautomatenv4.data.repos

import com.example.parkeerautomatenv4.data.local.ParkeerautomaatLocalDataSource
import com.example.parkeerautomatenv4.data.remote.ParkeerautomaatRemoteDataSource
import com.example.parkeerautomatenv4.utils.performGetOperation

class ParkeerautomaatRepository(
    private val parkeerautomaatLocalDataSource: ParkeerautomaatLocalDataSource,
    private val parkeerautomaatRemoteDataSource: ParkeerautomaatRemoteDataSource

) {

    fun getParkeerautomaat(id: String) = parkeerautomaatLocalDataSource.getParkeerautomaatById(id)


    fun getParkeerautomaten() = performGetOperation(
        databaseQuery = {parkeerautomaatLocalDataSource.getParkeerautomaten()},
        networkCall =  {parkeerautomaatRemoteDataSource.getparkeerautomaten()},
        saveCallResult = {parkeerautomaatLocalDataSource.saveParkeerautomaat(it.records)}
    )
}