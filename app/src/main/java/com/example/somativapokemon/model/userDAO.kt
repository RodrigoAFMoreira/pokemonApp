package com.example.somativapokemon.model

import androidx.room.*


@Dao
interface userDAO {
    @Query("Select * from user")
    fun getAll():List<user>

    @Insert
    fun insertAll(vararg city: user) // olhar

    @Update
    fun updatePokemon(city: user):Int

    @Delete
    fun deletePokemon(city: user):Int
}