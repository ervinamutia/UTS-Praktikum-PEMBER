package com.example.utspraktikumpember

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_linearLayout (private val list: ArrayList<data>):RecyclerView.Adapter<adapter_linearLayout.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_data, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gambar.setImageResource(list[position].gambarnya)
        holder.nama.text=list[position].nama
        holder.keterangan.text=list[position].keterangan
        holder.nim.text=list[position].nim
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambar = itemView.findViewById<ImageView>(R.id.widget_image)
        val nama = itemView.findViewById<TextView>(R.id.nama)
        val keterangan = itemView.findViewById<TextView>(R.id.keterangan)
        val nim = itemView.findViewById<TextView>(R.id.nim)
    }

}
