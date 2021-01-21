package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "records")
data class Parkeerautomaat(
    @ColumnInfo(name = "recordid")
    val recordid: String,
    @ColumnInfo(name = "fields")
    val fields: Parkeerautomaatfields
) : Parcelable {
    fun toDatabaseModel(): ParkeerautomaatEntity {
        return ParkeerautomaatEntity(recordid)
    }
}
