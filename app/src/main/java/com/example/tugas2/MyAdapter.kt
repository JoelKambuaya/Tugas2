package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val namalist : ArrayList<ItemData>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var onItemClick: ((ItemData) -> Unit)? = null

    class MyViewHolder(itemData: View) : RecyclerView.ViewHolder(itemData) {

        val gambar: ImageView = itemData.findViewById(R.id.imageView2)
        val nama: TextView = itemData.findViewById(R.id.idNamaGame)
        val developer: TextView = itemData.findViewById(R.id.idDeveloper)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = namalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val game = namalist[position]
        holder.gambar.setImageResource(game.gambar)
        holder.nama.text = game.nama
        holder.developer.text = game.developer

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(game)
        }
    }
}

