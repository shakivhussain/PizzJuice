package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Center(
   @SerializedName("latitude") val latitude: Double? = 0.0,
   @SerializedName("longitude") val longitude: Double? = 0.0
) : Parcelable