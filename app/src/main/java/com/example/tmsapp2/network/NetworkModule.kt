package com.example.tmsapp2.network

import com.example.tmsapp2.network.HeroFactAPI.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object NetworkModule {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder().
        addInterceptor(logging)
        .build()




    @Provides
    @Singleton
    fun provideRetrofitService(): HeroFactAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(httpClient)
        .build()
        .create(HeroFactAPI::class.java)

}