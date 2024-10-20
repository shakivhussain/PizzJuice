package com.shakiv.pizzjuice.data.service

import com.shakiv.pizzjuice.data.model.BusinessResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BusinessService {

    @GET("businesses/search")
    suspend fun searchBusinesses(
        @Header("Authorization") token: String,
        @Query("location") location : String,
        @Query("term") term : String,
        @Query("limit") limit : Int,
    ) :Response<BusinessResponse>
}