package com.example.project_laundry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.project_laundry.ROOM.*
import com.example.project_laundry.databinding.ActivityInputlaundryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class inputlaundry : AppCompatActivity() {

    private lateinit var binding: ActivityInputlaundryBinding
    private val db by lazy { database_laundry(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputlaundryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.inputData.setOnClickListener {
            this.insertcucian()
        }
    }
    private fun insertcucian(){
        CoroutineScope(Dispatchers.IO).launch {
            db.laundrydao().simpan(
                Laundry(
                    idcuci = 0,
                    binding.inputnamacuci.text.toString(),
                    binding.inputnocuci.text.toString().toInt(),
                    binding.inputberatcuci.text.toString(),

                )
            )
        }
    }
    private fun insertsetrika(){
        CoroutineScope(Dispatchers.IO).launch {
            db.laundrydao().simpan2(
                Laundry2(
                    id = 0,
                    binding.inputnamacuci.text.toString(),
                    binding.inputnocuci.text.toString().toInt(),
                    binding.inputberatcuci.text.toString(),

                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        this.insertsetrika()
    }

}