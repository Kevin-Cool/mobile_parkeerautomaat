package com.example.parkeerautomatenv4.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geometry(
        val coordinates: Coordinates
): Parcelable