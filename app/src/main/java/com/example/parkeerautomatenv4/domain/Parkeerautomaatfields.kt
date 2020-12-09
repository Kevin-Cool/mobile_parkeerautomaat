package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parkeerautomaatfields(
        val betaalmodus: String,
        val categorie: String,
        val bewonerszone: String,
        val status: String,
        val locatieomschrijving: String,
        val parkeertariefzone: String
): Parcelable
