package com.example.parkeerautomatenv4.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkeerautomatenv4.data.local.entity.FavoriteEntity

@Dao
interface FavoriteDao {
    @Transaction
    @Query("select * from favorites where recordid=:id ")
    fun getFavorite(id: String): LiveData<FavoriteEntity>

    @Transaction
    @Query("select * from favorites")
    fun getAllFavorite(): LiveData<List<FavoriteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Query("DELETE from favorites where recordid=:id")
    fun deleteFavorite(id: String)

}