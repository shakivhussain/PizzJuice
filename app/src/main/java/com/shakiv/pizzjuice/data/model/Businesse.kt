package com.shakiv.pizzjuice.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Businesse(
    @SerializedName("alias") val alias: String? = "",
    @SerializedName("business_hours") val business_hours: List<BusinessHour?>? = listOf(),
    @SerializedName("categories") val categories: List<Category?>? = listOf(),
    @SerializedName("coordinates") val coordinates: Coordinates? = Coordinates(),
    @SerializedName("display_phone") val display_phone: String? = "",
    @SerializedName("distance") val distance: Double? = 0.0,
    @SerializedName("id") val id: String? = "",
    @SerializedName("image_url") val image_url: String? = "",
    @SerializedName("is_closed") val is_closed: Boolean? = false,
    @SerializedName("location") val location: Location? = Location(),
    @SerializedName("name") val name: String? = "",
    @SerializedName("phone") val phone: String? = "",
    @SerializedName("price") val price: String? = "",
    @SerializedName("rating") val rating: Float? = 0f,
    @SerializedName("review_count") val review_count: Int? = 0,
    @SerializedName("transactions") val transactions: List<String?>? = listOf(),
    @SerializedName("url") val url: String? = ""
) : Parcelable