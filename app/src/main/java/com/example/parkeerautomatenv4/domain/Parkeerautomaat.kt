package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Parkeerautomaat(
    val recordid: String,
    val fields: Parkeerautomaatfields,
    val geometry: Geometry
): Parcelable

