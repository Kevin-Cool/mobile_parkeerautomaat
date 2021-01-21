package com.example.parkeerautomatenv4.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorites")
class FavoriteEntity(
    @PrimaryKey
    val recordid: String = ""
)
