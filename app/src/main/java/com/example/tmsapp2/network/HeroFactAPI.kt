package com.example.tmsapp2.network

import com.example.tmsapp2.model.HeroFactResponse
import retrofit2.Response
import retrofit2.http.GET

interface HeroFactAPI {

@GET ("characters")
    suspend fun getHeroFact():Response<List<HeroFactResponse>>

    companion object {
        const val BASE_URL = "https://api.disneyapi.dev/"
    }

}