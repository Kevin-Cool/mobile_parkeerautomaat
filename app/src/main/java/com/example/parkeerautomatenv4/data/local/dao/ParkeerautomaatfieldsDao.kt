package com.example.parkeerautomatenv4.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity

@Dao
interface ParkeerautomaatfieldsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ParkeerautomaatfieldsEntity>)

    @Query("DELETE FROM fields")
    fun clear()
}
