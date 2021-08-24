package com.icg.smac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.icg.smac.databinding.ActivityMainscreenBinding
import com.icg.smac.databinding.NavigationHeaderLayoutBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val drawerLayout = binding.root
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        binding.toolbarLayout.toolbar.setupWithNavController(navController, appBarConfiguration)

        binding.navView.setupWithNavController(navController)


        val navHLBinding = NavigationHeaderLayoutBinding.bind(binding.navView.getHeaderView(0))
        navHLBinding.root.setBackgroundResource(R.drawable.navigation_header_bg)
        navHLBinding.circleImageView.setImageResource(R.drawable.icg_logo_hd_circle_white_bg)
        navHLBinding.materialDrawerAccountHeaderName.text = "Ishaan Kumar"
        navHLBinding.materialDrawerAccountHeaderRole.text = "SuperAdmin"


    }
}