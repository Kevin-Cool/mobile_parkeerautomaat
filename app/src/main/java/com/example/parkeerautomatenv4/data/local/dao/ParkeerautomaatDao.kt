package com.example.parkeerautomatenv4.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity

@Dao
interface ParkeerautomaatDao {

    @Transaction
    @Query("select * from records")
    fun getAllParkeerautomaten() : LiveData<List<ParkeerautomaatAndFields>>

    @Transaction
    @Query("select * from records where recordid=:id")
    fun getParkeerautomaatById(id: String) : LiveData<ParkeerautomaatAndFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(List: List<ParkeerautomaatEntity>)

    @Query("DELETE FROM records")
    fun clear()
}