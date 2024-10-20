package com.shakiv.pizzjuice.di

import com.shakiv.pizzjuice.data.repository.BusinessRepository
import com.shakiv.pizzjuice.data.repository.BusinessesRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun bind(repositoryImp: BusinessesRepositoryImp) : BusinessRepository

}