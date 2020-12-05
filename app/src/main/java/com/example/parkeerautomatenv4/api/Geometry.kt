package com.example.parkeerautomatenv4.api

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "geometry")
data class Geometry(
        @ColumnInfo(name = "coordinates")
        @Embedded
        val Coordinates : Coordinates

) : Parcelable