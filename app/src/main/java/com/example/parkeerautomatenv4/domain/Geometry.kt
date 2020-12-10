package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "geometry")
data class Geometry(
        @ColumnInfo(name="coordinates")
    val coordinates: List<Float>?
): Parcelable