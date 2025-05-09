package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class forgot_password : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var recoveryButton: Button
    private lateinit var rememberLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

        emailEditText = findViewById(R.id.holderfor_email)
        recoveryButton = findViewById(R.id.button_recovery)
        rememberLink = findViewById(R.id.remember_link)

        recoveryButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Recovery untuk email: $email", Toast.LENGTH_SHORT).show()
            }
        }

        // Logika link Remember Account
        rememberLink.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }

    fun onRecoveryClick(view: android.view.View) {
        val email = emailEditText.text.toString()
        Toast.makeText(this, "Recovery untuk email: $email", Toast.LENGTH_SHORT).show()
        // Tambahkan logika recovery email di sini
    }

    fun onRememberClick(view: android.view.View) {
        val intent = Intent(this, login::class.java)
        startActivity(intent)
    }
}
