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

class MainActivity : AppCompatActivity() {
    private lateinit var loginLayout: LinearLayout
    private lateinit var registerLayout: LinearLayout
    private lateinit var textViewRegister: TextView
    private lateinit var textViewLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginLayout = findViewById(R.id.loginLayout)
        registerLayout = findViewById(R.id.registerLayout)
        textViewRegister = findViewById(R.id.textViewRegister)
        textViewLogin = findViewById(R.id.textViewLogin)

        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val buttonRegister: Button = findViewById(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            val usernameEditText: EditText = findViewById(R.id.editTextUsername)
            val passwordEditText: EditText = findViewById(R.id.editTextPassword)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            usernameEditText.setTextColor(Color.BLACK)
            passwordEditText.setTextColor(Color.BLACK)

            // Lakukan validasi data pengguna, misalnya dengan memeriksa ke database
            if (isValidUser(username, password)) {
                // Jika pengguna valid, tampilkan pesan berhasil login
                showToast("Login berhasil")

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Mengakhiri activity login agar tidak bisa kembali dengan tombol back
            } else {
                // Jika pengguna tidak valid, tampilkan pesan gagal login
                showToast("Login gagal")
            }
        }

        buttonRegister.setOnClickListener {
            val usernameEditText: EditText = findViewById(R.id.editTextName)
            val passwordEditText: EditText = findViewById(R.id.editTextRegisterUsername)
            val confirmPasswordEditText: EditText = findViewById(R.id.editTextRegisterPassword)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            usernameEditText.setTextColor(Color.BLACK)
            passwordEditText.setTextColor(Color.BLACK)
            confirmPasswordEditText.setTextColor(Color.BLACK)

            // Lakukan validasi data pendaftaran, misalnya dengan memeriksa ke database
            if (isValidRegistration(username, password, confirmPassword)) {
                // Jika pendaftaran valid, tampilkan pesan berhasil pendaftaran
                showToast("Pendaftaran berhasil")
            } else {
                // Jika pendaftaran tidak valid, tampilkan pesan gagal pendaftaran
                showToast("Pendaftaran gagal")
            }
        }

        textViewRegister.setOnClickListener {
            loginLayout.visibility = View.GONE
            registerLayout.visibility = View.VISIBLE
        }

        textViewLogin.setOnClickListener {
            registerLayout.visibility = View.GONE
            loginLayout.visibility = View.VISIBLE
        }

    }

    private fun isValidUser(username: String, password: String): Boolean {
        // Lakukan validasi pengguna di sini, misalnya dengan memeriksa ke database
        // Return true jika pengguna valid, false jika tidak valid
        // Contoh sederhana: username = "admin", password = "admin"
        return username == "admin" && password == "admin"
    }

    private fun isValidRegistration(username: String, password: String, confirmPassword: String): Boolean {
        // Lakukan validasi pendaftaran di sini, misalnya dengan memeriksa ke database
        // Return true jika pendaftaran valid, false jika tidak valid
        // Contoh sederhana: pastikan username dan password tidak kosong dan password sesuai dengan konfirmasi password
        return username.isNotEmpty() && password.isNotEmpty() && password == confirmPassword
    }

    private fun showToast(message: String) {
        // Tampilkan pesan toast di sini
        // Misalnya menggunakan Toast dari Android SDK
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}