package com.example.somativapokemon.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [user::class], version = 1)
abstract class userDatabase : RoomDatabase() {
    //abstract fun userDao(): userDAO

    companion object {
        private var INSTANCE: userDatabase? = null
        fun getInstance(context: Context): userDatabase? {
            if (INSTANCE == null) {
                synchronized(userDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        userDatabase::class.java,
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