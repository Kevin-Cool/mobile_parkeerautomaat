package com.example.parkeerautomatenv4.api

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "geometry")
data class Coordinates(
        @ColumnInfo(name = "0")
        val zero : Int,
        @ColumnInfo(name = "1")
        val one : Int

) : Parcelable