package com.sample.jetpack.msatestapplication.domain.usecase

import com.sample.jetpack.msatestapplication.domain.repository.BusinessRepository
import javax.inject.Inject

class GetAllPizzaUseCase @Inject constructor(private val repository: BusinessRepository) {

    suspend operator fun invoke(term: String, location: String, latitude: Double, longitude: Double) = repository.getAllPizzaBusinessData(term,location,latitude,longitude)
}