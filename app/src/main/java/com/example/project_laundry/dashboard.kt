package com.example.project_laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val cuci: ImageButton = findViewById(R.id.imgcuci)
        val setrika: ImageButton = findViewById(R.id.imgsetrika)


        cuci.setOnClickListener {
           startActivity(Intent(this,inputlaundry::class.java))
        }
        setrika.setOnClickListener {
            startActivity(Intent(this,inputlaundry::class.java))
        }



    }
}