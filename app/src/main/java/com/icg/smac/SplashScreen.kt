package com.icg.smac

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.*


class SplashScreen : AppCompatActivity() {

    companion object {
        private const val TAG = "SplashScreen"
        private val NEXT_ACTIVITY_TIMEOUT by lazy { 600L }
        private val ANIMATION_START_DELAY by lazy { 600L }
    }

    var nextActivityJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        } else {
            window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
        setContentView(R.layout.activity_splashscreen)
        GlobalScope.launch {
            delay(ANIMATION_START_DELAY)
            runTitleAnimation()
        }
        findViewById<ConstraintLayout>(R.id.splash_screen_root).setOnClickListener { proceedToNextActivity() }
        nextActivityJob = GlobalScope.launch() {
            delay(ANIMATION_START_DELAY + NEXT_ACTIVITY_TIMEOUT)
            proceedToNextActivity()
        }
    }

    private fun proceedToNextActivity() {
        startActivity(Intent(this, LoginScreen::class.java))
        nextActivityJob?.cancel()
        finish()
    }

    private fun runTitleAnimation() {
        with(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)){
            reset()
            (findViewById<View>(R.id.splash_screen_text) as TextView).let{
                it.clearAnimation()
                it.startAnimation(this)
            }
        }
    }

}