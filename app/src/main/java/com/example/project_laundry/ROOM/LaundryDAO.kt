package com.example.project_laundry.ROOM

import androidx.room.*

@Dao
interface LaundryDAO {
    //laundrycuci
    @Insert
    fun simpan(laundry: Laundry)

    @Update
    fun ubah (laundry: Laundry)


    @Delete
    fun hapus (laundry: Laundry)


    @Query ("SELECT * FROM tb_cuci")
    fun getAll(): List<Laundry>


    //laundrysetrika
    @Insert
    fun simpan2(laundry2: Laundry2)

    @Update
    fun ubah2(laundry2: Laundry2)

    @Delete
    fun hapus2(laundry2: Laundry2)

    @Query ("SELECT * FROM tb_setrika")
    fun getAll2(): List<Laundry2>

    //Register
    @Insert
    fun simpanregis(register: Register)









}