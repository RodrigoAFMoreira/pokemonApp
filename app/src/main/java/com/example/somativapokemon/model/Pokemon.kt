package com.example.somativapokemon.model

data class Pokemon (
    val imageUrl: String,
    val number: Int,
    val name: String,
    val types: List<PokemonType>
)
