package com.example.parkeerautomatenv4.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFieldsAndGeometry
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

@Dao
interface ParkeerautomaatDao {

    @Transaction
    @Query("select * from parkeerautomaat")
    fun getAllParkeerautomaten() : LiveData<List<ParkeerautomaatAndFieldsAndGeometry>>

    @Transaction
    @Query("select * from parkeerautomaat where recordid=:id")
    fun getParkeerautomaatById(id: String) : LiveData<ParkeerautomaatAndFieldsAndGeometry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ParkeerautomaatEntity>)

}