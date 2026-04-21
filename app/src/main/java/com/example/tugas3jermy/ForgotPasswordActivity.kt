package com.example.tugas3jermy

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val username = findViewById<EditText>(R.id.username)
        val newPassword = findViewById<EditText>(R.id.newPassword)
        val btnReset = findViewById<Button>(R.id.btnReset)

        val pref = getSharedPreferences("USER_DATA", MODE_PRIVATE)

        btnReset.setOnClickListener {
            val savedUser = pref.getString("username", "")

            if (username.text.toString() == savedUser) {
                val editor = pref.edit()
                editor.putString("password", newPassword.text.toString())
                editor.apply()

                Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}