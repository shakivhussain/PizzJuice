package com.shakiv.pizzjuice.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BusinessResponse(
    @SerializedName("businesses") val businesses: List<Businesse?>? = listOf(),
    @SerializedName("region") val region: Region? = Region(),
    @SerializedName("total") val total: Int? = 0
) : Parcelable