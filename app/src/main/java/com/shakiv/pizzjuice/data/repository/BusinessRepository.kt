package com.shakiv.pizzjuice.data.repository

import com.shakiv.pizzjuice.data.LoadState
import com.shakiv.pizzjuice.data.model.BusinessResponse
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {

    fun searchBusinesses( location: String,term: String) : Flow<LoadState>
}