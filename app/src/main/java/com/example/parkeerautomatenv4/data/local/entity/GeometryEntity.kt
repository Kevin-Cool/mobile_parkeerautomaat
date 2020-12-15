package com.example.parkeerautomatenv4.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "geometry", foreignKeys = arrayOf(
        ForeignKey(
                entity = ParkeerautomaatEntity::class,
                parentColumns = arrayOf("recordid"),
                childColumns = arrayOf("GeometryID"),
                onDelete = ForeignKey.CASCADE
        )
))
class GeometryEntity (
        val coordinates: List<Float>?,
        @ColumnInfo(name = "GeometryID", index = true)
        val parkeerautomaatID: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}