package com.icg.smac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.icg.smac.databinding.ActivityMainscreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val drawerLayout = binding.root
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        binding.toolbarLayout.toolbar.setupWithNavController(navController, appBarConfiguration)

        binding.navView.setupWithNavController(navController)

    }
}