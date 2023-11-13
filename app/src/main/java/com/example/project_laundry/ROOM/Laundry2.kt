package com.example.project_laundry.ROOM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tb_setrika")
data class Laundry2(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name ="idsetrika")
    val id : Int,
    @ColumnInfo(name = "Nama")
    val nama : String,
    @ColumnInfo(name = "No_Hp")
    val no : Int,
    @ColumnInfo(name = "Berat")
    val berat : String

)
