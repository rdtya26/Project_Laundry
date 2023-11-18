package com.example.project_laundry.ROOM

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.project_laundry.R
import com.example.project_laundry.detail

  class adapterlaundry(val list: ArrayList<Laundry>, var Listener: OnClickListener):
    RecyclerView.Adapter<adapterlaundry.laundryholder>(){
      class laundryholder(view: View) : RecyclerView.ViewHolder(view) {

            val NAMA = itemView.findViewById<TextView>(R.id.nameadapter)
            val TITIK3 = itemView.findViewById<ImageButton>(R.id.titik3)
            val EDIT = itemView.findViewById<ImageButton>(R.id.edit)
            val hapus = itemView.findViewById<ImageButton>(R.id.hapus)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): laundryholder {
            return laundryholder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter, parent, false)
            )
        }

        override fun onBindViewHolder(holder: laundryholder, position: Int) {

            holder.NAMA.text = list[position].namacuci
           holder.TITIK3.setOnClickListener{
             val context = holder.itemView.context
               val intent = Intent(context,detail::class.java).putExtra("username", list[position].idcuci.toString())
               context.startActivity(intent)
           }
            holder.EDIT.setOnClickListener {
                Listener.onEdit(list[position])
            }
            holder.hapus.setOnClickListener {
                Listener.onhapus(list[position])
            }


        }

        override fun getItemCount(): Int {
            return list.size
        }

    fun getData(newList: List<Laundry>){
        list.clear()
        list.addAll(newList)
    }


    interface OnClickListener{
        fun onDetail (laundry: Laundry)
        fun onEdit (laundry: Laundry)
        fun onhapus(laundry: Laundry)
    }
    }


