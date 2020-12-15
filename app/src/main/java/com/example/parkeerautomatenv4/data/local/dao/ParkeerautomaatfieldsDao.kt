package com.example.parkeerautomatenv4.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaatfields

@Dao
interface ParkeerautomaatfieldsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ParkeerautomaatfieldsEntity>)
}