package com.example.tmsapp2.arch

import com.example.tmsapp2.model.Hero

sealed class UiState {
    object Loading : UiState()
    data class HeroLoaded(val heroFacts: List<Hero>) : UiState()
    data class Error(val message: String) : UiState()
}