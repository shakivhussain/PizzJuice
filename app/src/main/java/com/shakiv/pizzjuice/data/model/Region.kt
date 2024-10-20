package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Region(
    @SerializedName("center") val center: Center? = Center()
) : Parcelable