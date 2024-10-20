package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Category(
   @SerializedName("alias") val alias: String? = "",
   @SerializedName("title") val title: String? = ""
) : Parcelable