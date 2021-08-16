package com.icg.smac

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowInsets

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        } else {
            window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
        setContentView(R.layout.activity_splashscreen)
    }

    fun onClicked(v: View) {
        startActivity(Intent(this, LoginScreen::class.java))
        finish()
    }
}