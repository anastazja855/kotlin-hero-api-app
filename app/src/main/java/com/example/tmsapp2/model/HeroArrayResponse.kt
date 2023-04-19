package com.example.tmsapp2.model

data class HeroArrayResponse(
    val count: Int,
    val message: List  <HeroFactResponse>,
    val nextPage: String,
    val totalPages: Int
)