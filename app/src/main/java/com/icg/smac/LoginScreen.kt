package com.icg.smac

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        } else {
            window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
        setContentView(R.layout.activity_login_screen)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        with(findViewById<AppCompatButton>(R.id.submit)) {
            setOnClickListener {
                val username = findViewById<TextInputEditText>(R.id.username).text.toString()
                val pass = findViewById<TextInputEditText>(R.id.password).text.toString()
                if (username.isBlank() || pass.isBlank()) {
                    Toast.makeText(
                        this@LoginScreen,
                        "Username and pass cannot be blank",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                doLogin(username,pass)
            }
        }
    }

    private fun doLogin(username: String, pass: String) {
        saveUserName(this, username)
        savePassword(this, pass)
        openDashboard()
    }

    private fun openDashboard() {
        startActivity(Intent(this, DashboardScreen::class.java))
        finish()
    }
}