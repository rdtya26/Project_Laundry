package com.example.project_laundry
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            this.insertsetrika()
        }

    }
    private fun insertcucian(){
        CoroutineScope(Dispatchers.IO).launch {
            db.laundrydao().simpan(
                Laundry(
                    0,
                    binding.inputnamacuci.text.toString(),
                    binding.inputnocuci.text.toString().toInt(),
                    binding.inputberatcuci.text.toString(),

                )
            )
            binding.inputnamacuci.setText("")
            binding.inputnocuci.setText("")
            binding.inputberatcuci.setText("")
        }
    }


    private fun insertsetrika(){
        CoroutineScope(Dispatchers.IO).launch {
            db.laundrydao().simpan2(
                Laundry2(
                    0,
                    binding.inputnamacuci.text.toString(),
                    binding.inputnocuci.text.toString().toInt(),
                    binding.inputberatcuci.text.toString(),
                )
            )
            binding.inputnamacuci.setText("")
            binding.inputnocuci.setText("")
            binding.inputberatcuci.setText("")
        }
        startActivity(Intent(this,tampildata::class.java))
    }


   /* override fun onResume() {
        super.onResume()
        this.insertsetrika()

    }*/
}