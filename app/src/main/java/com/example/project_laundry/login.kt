package com.example.project_laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project_laundry.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.loginuser
        val password = binding.loginpass

        binding.login.setOnClickListener{
            if (username.text.isNotEmpty()&& password.text.isNotEmpty()){
                if (password.text.length >= 7){
                    startActivity(
                        Intent(this,dashboard::class.java)
                            .putExtra("username", username.text.toString())
                    )
                    finish()
                    alert("Selamat datang di My Laundry ${username.text}")
                    finish()


                }else {
                    alert("Password minimal 8 huruf")
                }

            }else {
                alert("Username dan Password tidak boleh kosong!")
            }
        }
    }
    private fun alert(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
                }




