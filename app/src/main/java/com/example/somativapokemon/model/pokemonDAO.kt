package com.example.somativapokemon.model

import androidx.room.*


@Dao
interface pokemonDAO {
    @Query("Select * from pokemon")
    fun getAll():List<pokemon>

    @Insert
    fun insertAll(vararg city: pokemon)

    @Update
    fun updatePokemon(city: pokemon):Int

    @Delete
    fun deletePokemon(city: pokemon):Int
}