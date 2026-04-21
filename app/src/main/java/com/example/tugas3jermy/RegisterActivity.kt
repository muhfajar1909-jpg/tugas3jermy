package com.example.tugas3jermy

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val pref = getSharedPreferences("USER_DATA", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val editor = pref.edit()
            editor.putString("username", username.text.toString())
            editor.putString("password", password.text.toString())
            editor.apply()

            Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}