package com.example.parkeerautomatenv4.data.remote

import com.example.parkeerautomatenv4.data.BaseDataSource
import com.example.parkeerautomatenv4.domain.GetParkeerautomaatApiResponse

class ParkeerautomaatRemoteDataSource(val apiService: GhentApiService): BaseDataSource() {

    suspend fun  getparkeerautomaten() = getResult { apiService.getParkeerautomaten() }
}