package com.example.somativapokemon.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [pokemon::class], version = 1)
abstract class pokemonDatabase : RoomDatabase() {
    //abstract fun pokemonDao(): pokemonDAO

    companion object {
        private var INSTANCE: pokemonDatabase? = null
        fun getInstance(context: Context): pokemonDatabase? {
            if (INSTANCE == null) {
                synchronized(pokemonDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        pokemonDatabase::class.java,
                        "pokemon.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}