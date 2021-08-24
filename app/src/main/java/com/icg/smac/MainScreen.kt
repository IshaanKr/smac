package com.icg.smac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.icg.smac.databinding.ActivityMainscreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding:ActivityMainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}