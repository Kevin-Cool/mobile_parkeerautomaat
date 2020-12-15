package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fields")
data class Parkeerautomaatfields(
        @ColumnInfo(name="betaalmodus")
        val betaalmodus: String?,
        @ColumnInfo(name="categorie")
        val categorie: String?,
        @ColumnInfo(name="bewonerszone")
        val bewonerszone: String?,
        @ColumnInfo(name="status")
        val status: String?,
        @ColumnInfo(name="locatieomschrijving")
        val locatieomschrijving: String?,
        @ColumnInfo(name="parkeertariefzone")
        val parkeertariefzone: String?
): Parcelable{
        fun toDatabaseModel(parkeerautomaatfieldID: String) : ParkeerautomaatfieldsEntity{
                return ParkeerautomaatfieldsEntity(betaalmodus,categorie,bewonerszone,status,locatieomschrijving,parkeertariefzone,parkeerautomaatfieldID)
        }
}
