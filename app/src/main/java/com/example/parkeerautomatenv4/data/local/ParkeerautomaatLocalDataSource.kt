package com.example.parkeerautomatenv4.data.local

import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatfieldsDao
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import java.lang.Exception

class ParkeerautomaatLocalDataSource (private val parkeerautomaatDao: ParkeerautomaatDao, private val parkeerautomaatfieldsDao: ParkeerautomaatfieldsDao) {

    fun getParkeerautomaten() = parkeerautomaatDao.getAllParkeerautomaten()

    fun getParkeerautomaatById(id: String) = parkeerautomaatDao.getParkeerautomaatById(id)

    fun saveParkeerautomaat(list: List<Parkeerautomaat>){
        /*try {
            clearLocalParkkerautomaten()
        }catch (e: Exception){
            e.printStackTrace();
        }*/

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

}