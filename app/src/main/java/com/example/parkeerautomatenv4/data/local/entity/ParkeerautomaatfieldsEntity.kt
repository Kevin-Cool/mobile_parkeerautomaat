package com.example.parkeerautomatenv4.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "fields", foreignKeys = arrayOf(
        ForeignKey(
                entity = ParkeerautomaatEntity::class,
                parentColumns = arrayOf("recordid"),
                childColumns = arrayOf("ParkeerautomaatfieldID"),
                onDelete = ForeignKey.CASCADE
        )
))
class ParkeerautomaatfieldsEntity (
    val betaalmodus: String?,
    val categorie: String?,
    val bewonerszone: String?,
    val status: String?,
    val locatieomschrijving: String?,
    val parkeertariefzone: String?,
    @ColumnInfo(name = "ParkeerautomaatfieldID", index = true)
    val parkeerautomaatfieldID: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}