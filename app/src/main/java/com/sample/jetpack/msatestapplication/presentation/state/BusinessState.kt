package com.sample.jetpack.msatestapplication.presentation.state

import com.sample.jetpack.msatestapplication.domain.model.Business

data class BusinessState (
    val business: List<Business>? = arrayListOf(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)