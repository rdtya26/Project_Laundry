package com.example.project_laundry.ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register") // tableName = , bukan tableName:
data class Register (
    @PrimaryKey (autoGenerate = true)
    val username : Int, // username autogenerate harus int, ga boleh string -_-
    val email : String,
    val password : String
        )
