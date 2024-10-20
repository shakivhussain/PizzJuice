package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class BusinessHour(
   @SerializedName("hours_type") val hours_type: String? = "",
   @SerializedName("is_open_now") val is_open_now: Boolean? = false,
) : Parcelable