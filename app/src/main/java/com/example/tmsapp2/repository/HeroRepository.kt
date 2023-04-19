package com.example.tmsapp2.repository

import com.example.tmsapp2.network.HeroFactAPI
import javax.inject.Inject


class HeroRepository @Inject constructor(private val api: HeroFactAPI) {

    suspend fun getHeroFact() = api.getHeroArray(1)
}