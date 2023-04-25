package com.example.somativapokemon.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class pokemon(
    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "type")
    var population:Long){

    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}