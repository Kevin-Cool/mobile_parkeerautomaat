package com.example.parkeerautomatenv4.api

import android.os.Parcelable
import com.example.parkeerautomatenv4.domain.Parkeerautomaat
import kotlinx.android.parcel.Parcelize

@Parcelize
data class parkeerautomaten (
    var  parkeerautomatens : List<Parkeerautomaat>
): Parcelable

