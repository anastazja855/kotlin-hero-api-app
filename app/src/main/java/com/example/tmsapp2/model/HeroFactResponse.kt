package com.example.tmsapp2.model

data class HeroFactResponse(
    val characterId: Int,
    val imageUrl: String,
    val name: String,
    val movies: List<String>

//    val allies: List<String>,
//    val enemies: List<String>,
//    val films: List<String>,
//    val imageUrl: String,
//    val parkAttractions: List<String>,
//    val shortFilms: List<String>,
//    val tvShows: List<String>,
//    val url: String,
//    val videoGames: List<String>
)

data class Hero(
    val name: String,
    val imageUrl: String,
    val id: Int
)

fun List<HeroFactResponse>.mapToHeroes(): List<Hero> {
    return this.map { heroFactResponse ->
        Hero(
            name = heroFactResponse.name,
            imageUrl = heroFactResponse.imageUrl,
            id=heroFactResponse.characterId

        )
    }
}
