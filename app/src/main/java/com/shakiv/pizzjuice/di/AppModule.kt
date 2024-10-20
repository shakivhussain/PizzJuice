package com.shakiv.pizzjuice.di

import com.shakiv.pizzjuice.data.service.BusinessService
import com.shakiv.pizzjuice.utils.AppUtils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideBusinessService(retrofit: Retrofit) = retrofit.create(BusinessService::class.java)
}