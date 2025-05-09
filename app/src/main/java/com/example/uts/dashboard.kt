package com.example.uts

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        // Kalender
        val calendarRow = findViewById<LinearLayout>(R.id.calendar_row)
        calendarRow.setOnClickListener {
            showDatePicker()
        }

        // Icon fitur
        val buttonRow = findViewById<LinearLayout>(R.id.button_row)

        val featureClickListener = {
            Toast.makeText(this, "Fitur ini hanya UI tambahan", Toast.LENGTH_SHORT).show()
        }

        buttonRow.setOnClickListener { featureClickListener() }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val datalist = listOf(
            datalist("Kampus Merdeka Diganti Kampus Berdampak, Kapan Mulai Berlaku?", "Kampus Berdampak mulai dikenalkan pemerintah sebelum peluncuran resminya. Simak pengertian Kampus Berdampak sebagai pengganti", "https://www.msn.com/id-id/berita/other/kampus-merdeka-diganti-kampus-berdampak-kapan-mulai-berlaku/ar-AA1DWrxg?ocid=BingNewsVerp"),
            datalist("Kampus Jadi Pabrik Gelar Bukan Rumah Pikir", "Saat banyak kampus dikelola seperti perusahaan, orientasi pendidikan pun bergeser. Mahasiswa dianggap klien, bukan mitra", "https://kumparan.com/arc-cyn/kampus-jadi-pabrik-gelar-bukan-rumah-pikir-250LdrvPEaG"),
            datalist("Polda Jabar Amankan 2 Joki UTBK-SNBT di Kampus UPI", "Ditreskrimum Polda Jabar mengamankan dua orang joki UTBK-SNBT yang diselenggarakan di Kampus UPI Bandung", "https://www.msn.com/id-id/berita/nasional/polda-jabar-amankan-2-joki-utbk-snbt-di-kampus-upi/ar-AA1EmYpN?ocid=BingNewsVerp")
        )

        val adapter = adapterlist(datalist)
        recyclerView.adapter = adapter
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
