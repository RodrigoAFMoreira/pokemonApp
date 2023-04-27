package com.example.somativapokemon.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "password")
    var password:Long){

    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}