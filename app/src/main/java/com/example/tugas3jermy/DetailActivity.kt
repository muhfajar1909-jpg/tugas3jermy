package com.example.tugas3jermy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Hubungkan toolbar detail
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetail)
        setSupportActionBar(toolbar)

        // Aktifkan tombol back (kembali) di toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Inisialisasi komponen UI
        val tvNama = findViewById<TextView>(R.id.tvDetailNama)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDetailDeskripsi)

        // Tangkap data yang dikirim oleh Adapter via Intent
        val namaAktivitas = intent.getStringExtra("EXTRA_NAMA")
        val deskripsiAktivitas = intent.getStringExtra("EXTRA_DESKRIPSI")

        // Tampilkan data ke komponen TextView
        tvNama.text = namaAktivitas
        tvDeskripsi.text = deskripsiAktivitas
    }
}