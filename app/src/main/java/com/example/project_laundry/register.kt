package com.example.project_laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.project_laundry.ROOM.adapterlaundry
import com.example.project_laundry.ROOM.database_laundry

class register : AppCompatActivity() {

    lateinit var etuser: EditText
    lateinit var etemial: EditText
    private lateinit var etPass: EditText
    private lateinit var btnDaftar: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)

        etuser = findViewById(R.id.hintuser)
        etemial = findViewById(R.id.hintemail)
        etPass = findViewById(R.id.hintpass)
        btnDaftar = findViewById(R.id.btndaftar)

        btnDaftar.setOnClickListener {
            Daftar()
        }
        startActivity(
            Intent(this, login::class.java)

        )
    }

    private fun Daftar() {
        val user = etuser.text.toString()
        val email = etemial.text.toString()
        val pass = etPass.text.toString()

        if (user.isBlank() || email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            return
        }
        if (email != pass) {
            Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show()
            return
        }

    }
}