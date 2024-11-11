package com.sample.jetpack.msatestapplication.data.api

import com.sample.jetpack.msatestapplication.BuildConfig
import com.sample.jetpack.msatestapplication.data.dto.BusinessDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BusinessApi {

    @GET("v3/businesses/search")
    suspend fun getAllPizzaAndJuiceBusiness(
        @Query("term") term: String,
        @Query("location") location: String,
        //in case you want to get data using lat long, then un-comment below code.
//        @Query("latitude") latitude: Double,
//        @Query("longitude") longitude: Double,
        @Header("Authorization") authHeader: String = "Bearer ${BuildConfig.YELP_SEARCH_API_KEY}",
    ): BusinessDto
}