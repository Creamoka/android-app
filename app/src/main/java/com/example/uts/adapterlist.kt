package com.example.uts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class adapterlist(private val itemList: List<datalist>) :
    RecyclerView.Adapter<adapterlist.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.judul)
        val keterangan: TextView = itemView.findViewById(R.id.keterangan)
        val image: ImageView = itemView.findViewById(R.id.profile_user)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.judul.text = item.judul
        holder.keterangan.text = item.keterangan
        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.image)
    }

    override fun getItemCount() = itemList.size
}
