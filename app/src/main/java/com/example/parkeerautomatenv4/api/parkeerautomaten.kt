package com.example.parkeerautomatenv4.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class parkeerautomaten (
    var  parkeerautomatens : List<Parkeerautomaat>
): Parcelable

