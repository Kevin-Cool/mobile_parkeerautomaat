package com.example.parkeerautomatenv4.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkeerautomatenv4.data.local.ParkeerautomaatAndFields
import com.example.parkeerautomatenv4.data.local.entity.FavoriteEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity

@Dao
interface FavoriteDao {
    @Transaction
    @Query("select * from favorites where recordid=:id ")
    fun getFavorite(id: String): LiveData<FavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Query("DELETE from favorites where recordid=:id")
    fun deleteFavorite(id: String)

}