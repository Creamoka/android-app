package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Menghubungkan ID dengan elemen UI
        val emailField = findViewById<EditText>(R.id.holderlog_email)
        val passwordField = findViewById<EditText>(R.id.holderlog_password)
        val loginButton = findViewById<Button>(R.id.button_login)
        val forgotPasswordLink = findViewById<TextView>(R.id.forgot)
        val registerLink = findViewById<TextView>(R.id.register_link)
        val googleButton = findViewById<ImageView>(R.id.google)

        // Tombol Login
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                // Ambil data dari SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val registeredEmail = sharedPref.getString("email", null)
                val registeredPassword = sharedPref.getString("password", null)

                if (email == registeredEmail && password == registeredPassword) {
                    Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, dashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Link ke halaman Forgot Password
        forgotPasswordLink.setOnClickListener {
            val intent = Intent(this, forgot_password::class.java) // Ganti dengan nama activity yang sesuai
            startActivity(intent)
        }

        // Link ke halaman Register
        registerLink.setOnClickListener {
            val intent = Intent(this, register::class.java) // Ganti dengan nama activity yang sesuai
            startActivity(intent)
        }

        // Tombol Google (untuk testing)
        googleButton.setOnClickListener {
            Toast.makeText(this, "Google tidak tersedia", Toast.LENGTH_SHORT).show()
        }
    }
}
