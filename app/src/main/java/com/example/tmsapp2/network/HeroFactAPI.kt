package com.example.tmsapp2.network

import com.example.tmsapp2.model.HeroArrayResponse
import com.example.tmsapp2.model.HeroFactResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroFactAPI {

@GET ("characters")
    suspend fun getHeroArray(@Query("page") page:Int):Response<HeroArrayResponse>

    companion object {
        const val BASE_URL = "https://api.disneyapi.dev/"
    }

}