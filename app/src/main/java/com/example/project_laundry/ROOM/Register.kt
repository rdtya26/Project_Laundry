package com.example.project_laundry.ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Register")
data class Register (
    @PrimaryKey (autoGenerate = true)
    val username : String,
    val email : String,
    val password : String
        )
