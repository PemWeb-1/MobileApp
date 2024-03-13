package com.example.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textHome: TextView = findViewById(R.id.textHome)
        textHome.text = "Ini adalah halaman utama"

        // Lakukan inisialisasi komponen-komponen pada halaman utama di sini
    }
}