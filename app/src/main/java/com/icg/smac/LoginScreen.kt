package com.icg.smac

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.icg.smac.databinding.ActivityLoginScreenBinding
import com.icg.smac.interfaces.services.AuthService
import com.icg.smac.managers.RequestManager.Companion.BASE_URL
import com.icg.smac.models.requests.LoginReq
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginScreen : AppCompatActivity() {
    companion object {

        private const val TAG = "LoginScreen"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        } else {
            window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
        val binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.submit) {
            setOnClickListener {
                val username = binding.usernameEditText.text.toString()
                val pass = binding.passwordEditText.text.toString()
                if (username.isBlank() or pass.isBlank()) {
                    Toast.makeText(
                        this@LoginScreen,
                        "Username and pass cannot be blank",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                doLogin(username, pass)
            }
        }
    }

    lateinit var barProgressDialog: ProgressDialog

    private fun doLogin(username: String, pass: String) {


        StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())

        barProgressDialog = ProgressDialog.show(
            this,
            "Authenticating...",
            "Please Wait",
            true
        )


        val authService =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(AuthService::class.java)
        val tempLoginBlocking = authService.tempLoginBlocking(LoginReq("NCG", username, pass))
        Log.d(TAG, "doLogin: request: ${tempLoginBlocking.request().body()}")
        val res = tempLoginBlocking.execute()

        Log.d(TAG, "doLogin: response: ${res.body()!![0]}")

        if (res.isSuccessful && res.body()!![0].message == "Success") {
            onLoginSuccess(username, pass)
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
            onLoginFailed()
        }

    }

    private fun onLoginFailed() {
        barProgressDialog.cancel()
    }

    private fun onLoginSuccess(username: String, pass: String) {
        barProgressDialog.cancel()
        saveUserName(username)
        savePassword(pass)
        openDashboard()
    }

    private fun openDashboard() {
        startActivity(Intent(this, MainScreen::class.java))
        finish()
    }
}