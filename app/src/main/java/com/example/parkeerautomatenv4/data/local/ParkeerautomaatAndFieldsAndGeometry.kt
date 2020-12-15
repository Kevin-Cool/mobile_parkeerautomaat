package com.example.parkeerautomatenv4.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.parkeerautomatenv4.data.local.entity.GeometryEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import com.example.parkeerautomatenv4.domain.Parkeerautomaat

class ParkeerautomaatAndFieldsAndGeometry (

    @Embedded
    val parkeerautomaat: ParkeerautomaatEntity,

    @Relation(parentColumn = "recordid", entityColumn = "parkeerautomaatfieldID")
    val fields: ParkeerautomaatfieldsEntity,

    @Relation(parentColumn = "recordid", entityColumn = "GeometryID")
    val geometry: GeometryEntity
)