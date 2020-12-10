package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "records")
data class Parkeerautomaat(
        @ColumnInfo(name="recordid")
    val recordid: String?,
        @ColumnInfo(name="fields")
    val fields: Parkeerautomaatfields?,
        @ColumnInfo(name="geometry")
    val geometry: Geometry?
): Parcelable

