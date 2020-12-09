package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates(
        @ColumnInfo(name="0")
        val zero: Double,
        @ColumnInfo(name="1")
        val one: Double
): Parcelable