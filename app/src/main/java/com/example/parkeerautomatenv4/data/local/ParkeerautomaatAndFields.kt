package com.example.parkeerautomatenv4.data.local

import androidx.room.Embedded
import androidx.room.Relation
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity

class ParkeerautomaatAndFields (

    @Embedded
    val records: ParkeerautomaatEntity?,

    @Relation(parentColumn = "recordid", entityColumn = "parkeerautomaatfieldid")
    val fields: ParkeerautomaatfieldsEntity?
)