package com.example.project_laundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_laundry.ROOM.database_laundry
import com.example.project_laundry.databinding.ActivityDetailBinding

class detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val db by lazy { database_laundry.invoke(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var id =intent.getStringExtra("idcuci").toString().toInt()
        val data =  db.laundrydao().getAll()[0]

        binding.detailnama.setText(data.idcuci.toString())

    }
}