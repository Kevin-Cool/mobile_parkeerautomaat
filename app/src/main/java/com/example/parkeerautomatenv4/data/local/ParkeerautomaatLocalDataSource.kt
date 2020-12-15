package com.example.parkeerautomatenv4.data.local

import com.example.parkeerautomatenv4.data.local.dao.GeometryDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatDao
import com.example.parkeerautomatenv4.data.local.dao.ParkeerautomaatfieldsDao
import com.example.parkeerautomatenv4.data.local.entity.GeometryEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class ParkeerautomaatLocalDataSource (private val parkeerautomaatDao: ParkeerautomaatDao, private val parkeerautomaatfieldsDao: ParkeerautomaatfieldsDao, private val geometryDao: GeometryDao) {

    fun getParkeerautomaten() = parkeerautomaatDao.getAllParkeerautomaten()

    fun getParkeerautomaatById(id: String) = parkeerautomaatDao.getParkeerautomaatById(id)

    fun saveParkeerautomaat(list: List<Parkeerautomaat>){
        val parkeerautomaatList = ArrayList<ParkeerautomaatEntity>()
        list.forEach { parkeerautomaat -> parkeerautomaatList.add(parkeerautomaat.toDatabaseModel()) }
        parkeerautomaatDao.insertAll(parkeerautomaatList)

        val fieldsList = ArrayList<ParkeerautomaatfieldsEntity>()
        list.forEach { parkeerautomaat -> fieldsList.add(parkeerautomaat.fields.toDatabaseModel(parkeerautomaat.recordid))}
        parkeerautomaatfieldsDao.insertAll(fieldsList)

        val geometryList = ArrayList<GeometryEntity>()
        list.forEach { parkeerautomaat -> geometryList.add(parkeerautomaat.geometry.toDatabaseModel(parkeerautomaat.recordid)) }
        geometryDao.insertAll(geometryList)

    }

}