package com.example.tugas3jermy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AktivitasAdapter(private val listAktivitas: List<Pair<String, String>>) :
    RecyclerView.Adapter<AktivitasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaAktivitas)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsiAktivitas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_aktivitas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listAktivitas[position]
        holder.tvNama.text = data.first
        holder.tvDeskripsi.text = data.second

        // MENGUBAH AKSI KLIK: Berpindah ke DetailActivity membawa data item
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("EXTRA_NAMA", data.first)
                putExtra("EXTRA_DESKRIPSI", data.second)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listAktivitas.size
    }
}