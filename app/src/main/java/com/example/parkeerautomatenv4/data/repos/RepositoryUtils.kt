package com.example.parkeerautomatenv4.data.repos

import android.content.Context
import com.example.parkeerautomatenv4.data.local.AppDatabase
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatLocalDataSource
import com.example.parkeerautomatenv4.data.remote.GhentApi
import com.example.parkeerautomatenv4.data.remote.ParkeerautomaatRemoteDataSource

class RepositoryUtils {
    companion object{
        fun createParkeerautomaatRepository(context: Context): ParkeerautomaatRepository{
            val database = AppDatabase.getDatabase(context)
            val localDataSource = ParkeerautomaatLocalDataSource(database.parkeerautomaatDao(),database.parkeerautomaatfieldsDao())
            val remoteDataSource = ParkeerautomaatRemoteDataSource(GhentApi.apiService)

            return ParkeerautomaatRepository(localDataSource,remoteDataSource)
        }
    }
}