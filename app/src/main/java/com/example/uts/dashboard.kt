package com.example.uts

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class dashboard : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        // Info icon
        val infoIcon = findViewById<ImageView>(R.id.info)
        infoIcon.setOnClickListener {
            Toast.makeText(this, "Aplikasi UTS", Toast.LENGTH_SHORT).show()
        }

        // Profile button
        val profileButton = findViewById<Button>(R.id.profile_button)
        profileButton.setOnClickListener {
            Toast.makeText(this, "Hanya UI tambahan", Toast.LENGTH_SHORT).show()
        }

        // Kalender (misalnya hanya satu hari di klik)
        val calendarDay = findViewById<TextView>(R.id.calendar_row)
        calendarDay.setOnClickListener {
            showDatePicker()
        }

        // Icon fitur
        val icon1 = findViewById<ImageView>(R.id.button_row)
        val icon2 = findViewById<ImageView>(R.id.button_row)
        val icon3 = findViewById<ImageView>(R.id.button_row)

        val featureClickListener = {
            Toast.makeText(this, "Fitur ini hanya UI tambahan", Toast.LENGTH_SHORT).show()
        }

        icon1.setOnClickListener { featureClickListener() }
        icon2.setOnClickListener { featureClickListener() }
        icon3.setOnClickListener { featureClickListener() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(this,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                Toast.makeText(this, "Tanggal dipilih: $selectedDate", Toast.LENGTH_SHORT).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}
