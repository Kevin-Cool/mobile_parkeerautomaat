package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import androidx.room.Entity
import com.example.parkeerautomatenv4.data.local.entity.ParkeerautomaatfieldsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fields")
data class Parkeerautomaatfields(
        val betaalmodus: String,
        val categorie: String,
        val bewonerszone: String,
        val status: String,
        val locatieomschrijving: String,
        val parkeertariefzone: String
): Parcelable{
        fun toDatabaseModel(parkeerautomaatfieldID: String) : ParkeerautomaatfieldsEntity{
                return ParkeerautomaatfieldsEntity(betaalmodus,categorie,bewonerszone,status,locatieomschrijving,parkeertariefzone,parkeerautomaatfieldID)
        }
}
