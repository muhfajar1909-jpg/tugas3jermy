package com.example.tugas3jermy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Hubungkan toolbar dari XML ke kode Activity agar menunya muncul
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarHome)
        setSupportActionBar(toolbar)

        // 1. Inisialisasi komponen RecyclerView dari layout
        val rvAktivitas = findViewById<RecyclerView>(R.id.rvAktivitas)

        // 2. Siapkan data dummy untuk ditampilkan di dalam list RecyclerView
        val dataDummy = listOf(
            Pair("Praktek Android 1", "Materi mengenai instalasi dan perkenalan IDE."),
            Pair("Praktek Android 2", "Materi Layouting menggunakan LinearLayout."),
            Pair("Tugas Intent", "Mempraktikkan Implicit Intent bawaan HP."),
            Pair("Tugas RecyclerView", "Menampilkan list dinamis dan interaktif.")
        )

        // 3. Atur LayoutManager dan pasang Adapter ke RecyclerView
        rvAktivitas.layoutManager = LinearLayoutManager(this)
        rvAktivitas.adapter = AktivitasAdapter(dataDummy)

        // --- Inisialisasi Tombol Aksi ---
        val btnMaps = findViewById<Button>(R.id.btnMaps)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Jayapura"))
            startActivity(intent)
        }

        btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Halo dari aplikasi saya")
            startActivity(Intent.createChooser(intent, "Kirim ke"))
        }

        btnBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }

    // 1. Menghubungkan file menu XML ke dalam Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // 2. Menangani aksi klik pada item menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_profile -> {
                Toast.makeText(this, "Menu Profil Diklik", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_logout -> {
                // Berpindah kembali ke LoginActivity saat logout diklik
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Menutup HomeActivity agar tidak bisa di-back
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}