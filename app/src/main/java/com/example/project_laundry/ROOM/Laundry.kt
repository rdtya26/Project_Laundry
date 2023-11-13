package com.example.project_laundry.ROOM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tb_cuci")
data class Laundry(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "idcucian")
    val idcuci : Int,
    @ColumnInfo(name = "Nama")
    val namacuci: String,
    @ColumnInfo (name = "No_Hp")
    val No : Int,
    @ColumnInfo (name = "Berat")
    val berat : String

)