package com.example.parkeerautomatenv4.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "parkeerautomaat")
class ParkeerautomaatEntity (
        @PrimaryKey
    val recordid: String
)