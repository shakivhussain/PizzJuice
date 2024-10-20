package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Location(
    @SerializedName("address1") val address1: String? = "",
    @SerializedName("address2") val address2: String? = "",
    @SerializedName("address3") val address3: String? = "",
    @SerializedName("city") val city: String? = "",
    @SerializedName("country") val country: String? = "",
    @SerializedName("display_address") val display_address: List<String?>? = listOf(),
    @SerializedName("state") val state: String? = "",
    @SerializedName("zip_code") val zip_code: String? = ""
) : Parcelable{
    fun getFormattedDisplayAddress(): String {
        return display_address?.filterNotNull()?.joinToString(" , ") ?: ""
    }
}