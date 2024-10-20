package com.shakiv.pizzjuice.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shakiv.pizzjuice.data.LoadState
import com.shakiv.pizzjuice.data.repository.BusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val businessRepository: BusinessRepository
) : ViewModel() {

    private val _businesses = MutableSharedFlow<LoadState>()
    val businesses = _businesses.asSharedFlow()

    var selectedTerm: String = "Pizza"
    var searchText: String = "New York"

    fun searchBusiness(location: String, term: String) {
        viewModelScope.launch {
            businessRepository.searchBusinesses(location, term).collectLatest {
                when (it) {
                    is LoadState.Loading -> {
                        _businesses.emit(LoadState.Loading)
                    }

                    is LoadState.Success -> {
                        _businesses.emit(LoadState.Success(it.businessResponse))
                    }

                    is LoadState.Error -> {
                        _businesses.emit(LoadState.Error(it.message))
                    }
                }
            }
        }
    }

}