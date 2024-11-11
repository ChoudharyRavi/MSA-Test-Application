package com.sample.jetpack.msatestapplication.data.repository

import com.sample.jetpack.msatestapplication.core.common.Resource
import com.sample.jetpack.msatestapplication.data.api.BusinessApi
import com.sample.jetpack.msatestapplication.data.mappper.toDomainCharacter
import com.sample.jetpack.msatestapplication.domain.model.Business
import com.sample.jetpack.msatestapplication.domain.repository.BusinessRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class BusinessRepositoryImpl @Inject constructor(private val businessApi: BusinessApi) :
    BusinessRepository {

    override suspend fun getAllPizzaBusinessData(
        term: String,
        location: String,
        latitude: Double,
        longitude: Double
    ): Flow<Resource<ArrayList<Business>>> = flow {

        emit(Resource.Loading())
        val result = businessApi.getAllPizzaAndJuiceBusiness(
            term = term,
            location = location,
            //in case you want to get data using lat long, then un-comment below code.
//            latitude = latitude,
//            longitude = longitude
        ).businesses?.map {
            it?.toDomainCharacter() ?: Business()
        }
        emit(Resource.Success(result as ArrayList))
    }.flowOn(
        Dispatchers.IO
    ).catch {
        emit(Resource.Error(it.message.toString()))
    }

}