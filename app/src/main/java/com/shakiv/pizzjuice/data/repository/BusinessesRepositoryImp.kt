package com.shakiv.pizzjuice.data.repository

import com.shakiv.pizzjuice.data.LoadState
import com.shakiv.pizzjuice.data.service.BusinessService
import com.shakiv.pizzjuice.utils.AppUtils.API_KEY
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BusinessesRepositoryImp @Inject constructor(
    private val businessService: BusinessService
) : BusinessRepository {
    override fun searchBusinesses(
        location: String,
        term: String,
    ) = flow {
        emit(LoadState.Loading)
        try {
            val response = businessService.searchBusinesses(API_KEY, location, term, 20)
            if (response.isSuccessful) {
                emit(LoadState.Success(response.body()))
            } else {
                emit(LoadState.Error(""))
            }
        } catch (e: Exception) {
            emit(LoadState.Error("Something went wrong!"))
        }

    }

}