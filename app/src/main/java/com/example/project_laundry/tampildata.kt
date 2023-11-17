package com.example.project_laundry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.project_laundry.ROOM.*
import com.example.project_laundry.databinding.ActivityTampildataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampildata : AppCompatActivity() {

    private lateinit var binding: ActivityTampildataBinding
    private val db by lazy { database_laundry(this) }
    private lateinit var adapterlaundry: adapterlaundry
    private lateinit var databaseLaundry: database_laundry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityTampildataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterlaundry = adapterlaundry(arrayListOf(),
            object : adapterlaundry.OnClickListener{
                override fun onDetail(laundry: Laundry) {
                   detail(laundry)

                }

                override fun onEdit(laundry: Laundry) {
                updateData(laundry)
            }

                override fun onhapus(laundry: Laundry) {
                    hapus(laundry)

                }

        }
        )
        
        binding.listcuci.adapter = adapterlaundry
        binding.listcuci.layoutManager = LinearLayoutManager(applicationContext,
        VERTICAL,false)
        binding.listcuci.addItemDecoration(
            DividerItemDecoration(
                applicationContext,LinearLayoutManager.VERTICAL
            )
        )

        binding.flaoting.setOnClickListener{
            startActivity(Intent(this,
                dashboard::class.java)
            )
        }
    }

    private fun hapus(laundry: Laundry){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("detail")
            setMessage("yakin akan menghapus")
            setNegativeButton("batal"){
                dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
            }
            setPositiveButton("hapus"){
                dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
        }
            dialog.show()
    }
    }

    private fun detail(laundry: Laundry){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("detail")
            setMessage("lihat detail laundry mu")
            setNegativeButton("batal"){
                dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
            }
            setPositiveButton("Edit"){
                    dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
            }
        }
        startActivity(Intent(this,detail::class.java))
    }

    private fun updateData(laundry: Laundry){
       val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("konfirmasi edit laundry")
            setMessage("apakah kamu yakin akan mengubah data ${laundry.idcuci}?")
            setNegativeButton("batal"){
                dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
            }
            setPositiveButton("Edit"){
                dialogInterface:DialogInterface,i:Int->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.laundrydao().ubah(laundry)
                    finish()
                    startActivity(intent)
                }
            }
            dialog.show()
        }
    }

    fun getdata(){
        binding.listcuci.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.laundrydao().getAll()
            adapterlaundry.list.addAll(data)
            withContext(Dispatchers.Main){
                adapterlaundry.notifyDataSetChanged()
            }
            }
        binding.listcuci.adapter = adapterlaundry
        }

    override fun onResume() {
        super.onResume()
        getdata()

    }
    }
