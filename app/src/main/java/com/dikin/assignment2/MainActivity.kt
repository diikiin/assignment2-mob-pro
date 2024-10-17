package com.dikin.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_feed_fragment,
                R.id.search_fragment,
                R.id.add_post_fragment,
                R.id.notifications_fragment,
                R.id.profile_fragment -> {
                    navController.navigate(item.itemId)
                    true
                }

                else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.home_feed_fragment) {
            super.onBackPressed()
        } else {
            navController.popBackStack()
        }
    }
}
