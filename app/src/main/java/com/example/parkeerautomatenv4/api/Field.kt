package com.example.parkeerautomatenv4.api

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "field")
data class Field(
        @ColumnInfo(name = "betaalmodus")
        val betaalmodus : String,
        @ColumnInfo(name = "categorie")
        val categorie : String,
        @ColumnInfo(name = "bewonerszone")
        val bewonerszone : String,
        @ColumnInfo(name = "locatieomschrijving")
        val locatieomschrijving : String,
        @ColumnInfo(name = "parkeertariefzone")
        val parkeertariefzone : String

) : Parcelable