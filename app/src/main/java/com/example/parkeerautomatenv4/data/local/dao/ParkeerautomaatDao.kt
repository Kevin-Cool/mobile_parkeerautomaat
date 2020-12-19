package com.example.parkeerautomatenv4.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import retrofit2.http.DELETE

@Dao
interface ParkeerautomaatDao {

    @Transaction
    @Query("select * from parkeerautomaat")
    fun getAllParkeerautomaten() : LiveData<List<ParkeerautomaatAndFields>>

    @Transaction
    @Query("select * from parkeerautomaat where recordid=:id")
    fun getParkeerautomaatById(id: String) : LiveData<ParkeerautomaatAndFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ParkeerautomaatEntity>)

    @Query("DELETE FROM parkeerautomaat")
    fun clear()
}