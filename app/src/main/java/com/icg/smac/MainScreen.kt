package com.icg.smac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.icg.smac.databinding.ActivityMainscreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding:ActivityMainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarLayout.toolbar)

        supportActionBar?.title = "Dashboard"
    }
}