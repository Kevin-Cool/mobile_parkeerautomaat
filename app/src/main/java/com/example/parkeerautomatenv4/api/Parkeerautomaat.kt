package com.example.parkeerautomatenv4.api
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "records")
data class Parkeerautomaat(
        @PrimaryKey @ColumnInfo(name = "recordid")
    val id : String,
        @ColumnInfo(name="fields")
        @Embedded
    var fields : Field,
        @ColumnInfo(name="geometry")
        @Embedded
    var geometry: Geometry


) : Parcelable