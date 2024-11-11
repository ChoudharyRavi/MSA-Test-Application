package com.sample.jetpack.msatestapplication.domain.repository

import com.sample.jetpack.msatestapplication.core.common.Resource
import com.sample.jetpack.msatestapplication.domain.model.Business
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {

    suspend fun getAllPizzaBusinessData(
        term: String,
        location: String,
        latitude: Double,
        longitude: Double
    ): Flow<Resource<ArrayList<Business>>>
}