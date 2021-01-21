package com.example.parkeerautomatenv4.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
class ParkeerautomaatEntity(
    @PrimaryKey
    val recordid: String = ""
)
