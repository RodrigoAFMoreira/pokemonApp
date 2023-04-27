package com.example.somativapokemon.model

import androidx.room.*


@Dao
interface UserDAO {
    @Query("Select * from User")
    fun getAll():List<User>

    @Insert
    fun insertAll(vararg city: User) // olhar

    @Update
    fun updatePokemon(city: User):Int

    @Delete
    fun deletePokemon(city: User):Int
}