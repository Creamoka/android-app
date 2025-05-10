# 🌤️ Aplikasi Cloud-U (Elearning Sederhana) - UTS Android Studio

Proyek ini merupakan aplikasi Android sederhana yang dibuat untuk keperluan Ujian Tengah Semester (UTS). Aplikasi menampilkan **splash screen**, **login**, dan **dashboard** dengan daftar berita menggunakan **RecyclerView**, serta menerapkan berbagai konsep dasar Android seperti `findViewById`, animasi, dan error handling.

## 🧩 Struktur Fitur

### 1. Splash Screen
- Animasi fade-in untuk logo dan teks.
- Redirect otomatis ke halaman login setelah 2 detik.

**File:** `splashscreen.kt`, `res/layout/splashscreen.xml`

### 2. Login Activity
- Form login sederhana dengan validasi input.
- Berpindah ke dashboard jika login berhasil.

**File:** `login.kt`, `res/layout/login.xml`

### 3. Dashboard
- Menampilkan daftar berita menggunakan `RecyclerView`.
- Setiap item menampilkan gambar, judul, dan deskripsi.

**File:** `dashboard.kt`, `res/layout/dashboard.xml`, `adapter.kt`, `model.kt`, `item_list.xml`

## 🧪 Error Handling & Contoh Kesalahan
### 1. `NullPointerException`
Terjadi jika `findViewById` digunakan sebelum `setContentView()` atau ID tidak ditemukan di layout.

### 2. `ClassCastException`
Misalnya, `findViewById<TextView>(R.id.layout_utama)` padahal `layout_utama` adalah `LinearLayout`.

### 3. `Resources.NotFoundException`
Dapat terjadi jika resource tidak ditemukan, seperti memanggil `getString(R.string.salah_id)` yang tidak ada.

## 🖥️ Logcat
- Semua error dapat dipantau melalui **Logcat** di Android Studio.
- Gunakan filter: `Show only selected application` dan `Verbose` atau `Error`.

## 🔧 Tools & Library
- Android Studio
- Kotlin
- XML Layout
- RecyclerView
- Handler dan Looper
- Animation (`fade_in.xml`)
- Drawable Resources (`rounded_bg.xml`, icon user)

## 🧠 Catatan Teknis
- `findViewById` wajib digunakan setelah `setContentView`.
- Pastikan ID view cocok antara XML dan Kotlin.
- Animasi diatur menggunakan `AnimationUtils.loadAnimation`.
- Hindari casting objek view ke tipe yang salah.

## ⚠️ Catatan
- Terdapat banyak **bug** kecil yang belum diperbaiki.
- Tampilan **tidak responsif** di beberapa perangkat dan ukuran layar berbeda.
- Komponen UI bisa **berantakan** di device dengan resolusi yang berbeda-beda.
- Beberapa **logika program** masih tidak konsisten atau tidak jelas alurnya.
- Rencana ke depan akan dibuat **versi remake** yang lebih rapi, kompatibel, dan stabil.

## 📌 Lisensi
Proyek ini dibuat untuk menyelesaikan uts mata kuliah Pemograman Mobile I.

---

