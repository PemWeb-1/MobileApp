package com.example.login

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LogReg(private val context: AppCompatActivity) {

    private lateinit var loginLayout: LinearLayout
    private lateinit var registerLayout: LinearLayout
    private lateinit var textViewRegister: TextView
    private lateinit var textViewLogin: TextView

    init {
        loginLayout = context.findViewById(R.id.loginLayout)
        registerLayout = context.findViewById(R.id.registerLayout)
        textViewRegister = context.findViewById(R.id.textViewRegister)
        textViewLogin = context.findViewById(R.id.textViewLogin)

        val buttonLogin: Button = context.findViewById(R.id.buttonLogin)
        val buttonRegister: Button = context.findViewById(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            val usernameEditText: EditText = context.findViewById(R.id.editTextUsername)
            val passwordEditText: EditText = context.findViewById(R.id.editTextPassword)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

//            usernameEditText.setTextColor(Color.BLACK)
//            passwordEditText.setTextColor(Color.BLACK)

            if (isValidUser(username, password)) {
                showToast("Login berhasil")

                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
                context.finish()
            } else {
                showToast("Login gagal")
            }
        }

        buttonRegister.setOnClickListener {
            val usernameEditText: EditText = context.findViewById(R.id.editTextName)
            val passwordEditText: EditText = context.findViewById(R.id.editTextRegisterUsername)
            val confirmPasswordEditText: EditText = context.findViewById(R.id.editTextRegisterPassword)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

//            usernameEditText.setTextColor(Color.BLACK)
//            passwordEditText.setTextColor(Color.BLACK)
//            confirmPasswordEditText.setTextColor(Color.BLACK)

            if (isValidRegistration(username, password, confirmPassword)) {
                showToast("Pendaftaran berhasil")
            } else {
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
        return username == "admin" && password == "admin"
    }

    private fun isValidRegistration(username: String, password: String, confirmPassword: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty() && password == confirmPassword
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}