package com.shakiv.pizzjuice.data

import com.shakiv.pizzjuice.data.model.BusinessResponse

sealed class LoadState {
    data object Loading : LoadState()
    data class Success(val businessResponse: BusinessResponse?) : LoadState()
    data class Error(val message: String) : LoadState()
}
