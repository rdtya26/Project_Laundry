package com.example.project_laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.project_laundry.ROOM.Laundry2
import com.example.project_laundry.ROOM.database_laundry
import com.example.project_laundry.databinding.ActivityEditLaundryBinding

class edit_laundry : AppCompatActivity() {
    private lateinit var binding: ActivityEditLaundryBinding
    private lateinit var database: database_laundry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditLaundryBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_edit_laundry)



        binding.editlaundry.setOnClickListener {
            if(binding.inputnamaedit.text.isNotEmpty() &&
                binding.inputnoedit.text.isNotEmpty() &&
               binding.inputberatedit.text.isNotEmpty()

            ){

                database.laundrydao().ubah2(
                    Laundry2(0,
                        binding.inputnamaedit.text.toString(),
                        binding.inputnoedit.text.toString().toInt(),
                        binding.inputberatedit.text.toString()

                    )
                )
                binding.inputnamaedit.setText("")
                binding.inputnoedit.setText("")
                binding.inputberatedit.setText("")


                startActivity(
                    Intent(
                        this,detail::class.java
                    )
                )
            } else{
                Toast.makeText(applicationContext,"isi semua kolom terlebih dahulu",
                Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,detail::class.java))
                finish()
            }
        }

    }
}