package com.example.uts

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class register : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var termsCheckbox: CheckBox
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        nameInput = findViewById(R.id.holderreg_name)
        emailInput = findViewById(R.id.holderreg_email)
        passwordInput = findViewById(R.id.holderreg_password)
        confirmPasswordInput = findViewById(R.id.holderreg_confirm_password)
        termsCheckbox = findViewById(R.id.checkbox_terms)
        registerButton = findViewById(R.id.button_login)

        registerButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val name = nameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()
        val confirmPassword = confirmPasswordInput.text.toString().trim()
        val isTermsChecked = termsCheckbox.isChecked

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showToast("Semua field harus diisi!")
            return
        }

        if (password != confirmPassword) {
            showToast("Password dan konfirmasi tidak cocok!")
            return
        }

        if (!isTermsChecked) {
            showToast("Kamu harus menyetujui syarat & ketentuan!")
            return
        }

        // Simpan ke SharedPreferences
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()

        showToast("Registrasi berhasil!")

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 1500)
    }

    private fun showToast(string: String) {}
}
