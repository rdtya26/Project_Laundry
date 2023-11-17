package com.example.project_laundry.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project_laundry.register

@Database(entities = [Laundry::class, Laundry2::class, Register::class], version = 2)
abstract class database_laundry : RoomDatabase(){
    abstract fun laundrydao() : LaundryDAO


    companion object{

        @Volatile
        var instance: database_laundry? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }

        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,database_laundry::class.java,
            "Mugi jaya Laundry"
        ).fallbackToDestructiveMigration().build()


    }
}