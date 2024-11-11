package com.sample.jetpack.msatestapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.jetpack.msatestapplication.domain.usecase.GetAllJuiceUseCase
import com.sample.jetpack.msatestapplication.domain.usecase.GetAllPizzaUseCase
import com.sample.jetpack.msatestapplication.presentation.state.BusinessState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(
    private val useCase: GetAllPizzaUseCase,
    private val juiceUseCase: GetAllJuiceUseCase,
) : ViewModel() {

    private val _businessState = MutableStateFlow(BusinessState())
    val businessState: StateFlow<BusinessState>
        get() = _businessState

    fun getAllCharacters(
        term: String,
        term2: String,
        location: String,
        latitude: Double,
        longitude: Double,
    ) {
        viewModelScope.launch {


            useCase.invoke(term, location, latitude, longitude)
                .combine(juiceUseCase.invoke(term2, location, latitude, longitude)) { list1, list2 ->
                    if (list1.data?.isNotEmpty() == true && list2.data?.isNotEmpty() == true) {
                        list1.data + list2.data // Combine the lists
                    } else {
                        emptyList()
                    }
                }
                .collect { combinedList ->
                    _businessState.value = BusinessState(business = combinedList)
                }
        }
    }
}