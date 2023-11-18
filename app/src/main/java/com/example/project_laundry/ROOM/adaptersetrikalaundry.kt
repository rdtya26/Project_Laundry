package com.example.project_laundry.ROOM

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_laundry.R
import com.example.project_laundry.detail

class adaptersetrikalaundry(val list: ArrayList<Laundry2>, var Listener: OnClickListener):
    RecyclerView.Adapter<adaptersetrikalaundry.laundryholder>(){
    class laundryholder(view: View) : RecyclerView.ViewHolder(view) {

            val NAMA = itemView.findViewById<TextView>(R.id.nameadapter)
            val TITIK3 = itemView.findViewById<ImageButton>(R.id.titik3set)
            val EDIT = itemView.findViewById<ImageButton>(R.id.editset)
            val hapus = itemView.findViewById<ImageButton>(R.id.hapusset)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): laundryholder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.adapter,
                parent,
                false

            )
            return laundryholder(view)
        }

        override fun onBindViewHolder(holder: laundryholder, position: Int) {
            holder.NAMA.text  = list[position].nama
            holder.TITIK3.setOnClickListener(){
                val context = holder.itemView.context
                val intent = Intent(context, detail::class.java).putExtra("username", list[position].id.toString())
                context.startActivity(intent)}
            holder.EDIT.setOnClickListener(){
                Listener.onEdit(list[position])}
            holder.hapus.setOnClickListener(){
                Listener.onhapus(list[position])
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }

    fun getAll2(newlist: List<Laundry2>){
        list.clear()
        list.addAll(newlist)
    }

    interface OnClickListener{
        fun onDetail (laundry2: Laundry2)
        fun onEdit (laundry2: Laundry2)
        fun onhapus(laundry2: Laundry2)
    }
    }


