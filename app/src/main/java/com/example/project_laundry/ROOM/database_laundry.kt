package com.example.project_laundry.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project_laundry.register

/* dari mz_zub:
1. perbaikan entitas dari [Laundry::class],[Laundry2::class] menjadi [Laundry::class, Laundry2::class]
2. Penambahan exportSchema
3. Data table Register belum masuk

--> Nilai kelompokmu kurang banyak soale error e okeh men
 */
@Database(entities = [Laundry::class, Laundry2::class, Register::class], version = 2, exportSchema = false)
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