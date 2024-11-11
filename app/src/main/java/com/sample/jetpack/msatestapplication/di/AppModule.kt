package com.sample.jetpack.msatestapplication.di

import com.sample.jetpack.msatestapplication.BuildConfig
import com.sample.jetpack.msatestapplication.core.utils.Constants.BASE_URL
import com.sample.jetpack.msatestapplication.data.api.BusinessApi
import com.sample.jetpack.msatestapplication.data.repository.BusinessRepositoryImpl
import com.sample.jetpack.msatestapplication.domain.repository.BusinessRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideBusinessApi(retrofit: Retrofit) : BusinessApi = retrofit.create(BusinessApi::class.java)

    @Provides
    @Singleton
    fun provideBusinessRepository(characterApi: BusinessApi) : BusinessRepository {
        return BusinessRepositoryImpl(characterApi)
    }

    private fun getHttpClient(): OkHttpClient {
        val client: OkHttpClient
        val builder = OkHttpClient().newBuilder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        client = builder.build()
        return client
    }
}