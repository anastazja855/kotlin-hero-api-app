package com.example.tmsapp2.navigation

sealed class Screen (val route: String) {
    object HeroGallery : Screen("heroGallery")
    object HeroDetail : Screen("heroDetail/{id}")
}
