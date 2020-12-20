package com.example.parkeerautomatenv4.data.local

import android.os.AsyncTask
import com.example.parkeerautomatenv4.data.local.dao.FavoriteDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatfieldsDao
import com.example.parkeerautomatenv4.data.local.entity.FavoriteEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import java.lang.Exception

class ParkeerautomaatLocalDataSource (private val parkeerautomaatDao: ParkeerautomaatDao, private val parkeerautomaatfieldsDao: ParkeerautomaatfieldsDao,private val favoriteDao: FavoriteDao ) {

    fun getParkeerautomaten() = parkeerautomaatDao.getAllParkeerautomaten()

    fun getParkeerautomaatById(id: String) = parkeerautomaatDao.getParkeerautomaatById(id)

    fun saveParkeerautomaat(list: List<Parkeerautomaat>){
        try {
            clearLocalParkkerautomaten()
        }catch (e: Exception){ }

        val parkeerautomaatList = ArrayList<ParkeerautomaatEntity>()
        list.forEach { parkeerautomaat -> parkeerautomaatList.add(parkeerautomaat.toDatabaseModel()) }
        parkeerautomaatDao.insertAll(parkeerautomaatList)

        val fieldsList = ArrayList<ParkeerautomaatfieldsEntity>()
        list.forEach { parkeerautomaat -> fieldsList.add(parkeerautomaat.fields.toDatabaseModel(parkeerautomaat.recordid))}
        parkeerautomaatfieldsDao.insertAll(fieldsList)

    }
    fun clearLocalParkkerautomaten(){
        parkeerautomaatDao.clear()
        parkeerautomaatfieldsDao.clear()
    }
    fun getFavorite(id: String) = favoriteDao.getFavorite(id)
    fun getAllFavorite() = favoriteDao.getAllFavorite()

    fun addFavorite(id: String) {
        Thread {
            favoriteDao.insertFavorite(FavoriteEntity(id))
        }.start()
    }

    fun deleteFavorite(id: String) {
        Thread {
            favoriteDao.deleteFavorite(id)
        }.start()
    }

}