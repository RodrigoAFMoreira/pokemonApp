package com.example.somativapokemon.model

data class pokemon (
    val imageUrl: String,
    val number: Int,
    val name: String,
    val types: List<pokemonType>
)

data class pokemonType(
    val name: String
)