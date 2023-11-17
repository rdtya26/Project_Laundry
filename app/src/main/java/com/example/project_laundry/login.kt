package com.example.project_laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var et_user = findViewById(R.id.loginuser) as EditText
        var et_pass = findViewById(R.id.loginpass) as EditText
        var btnlogin = findViewById(R.id.login) as Button
        var buatakunbaru = findViewById(R.id.buatakunbaru) as TextView


       btnlogin.setOnClickListener{
           val username = et_user.text.toString()
           val password = et_pass.text.toString()
           Toast.makeText(this@login, "mm", Toast.LENGTH_SHORT).show()
           startActivity(Intent(this,register::class.java))
       }
    }
}




