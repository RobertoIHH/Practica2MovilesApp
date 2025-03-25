package com.example.principal.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.principal.R
import com.example.principal.api.SessionManager
import com.example.principal.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var sessionManager: SessionManager
    private val topLevelDestinations = setOf(
        R.id.homeFragment,
        R.id.booksFragment,
        R.id.moviesFragment,
        R.id.profileFragment,
        R.id.adminFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar SessionManager
        sessionManager = SessionManager(this)

        // Configurar Toolbar
        setSupportActionBar(binding.toolbar)

        // Configurar Navigation Component
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(topLevelDestinations, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configurar Navigation Drawer
        binding.navigationView.setupWithNavController(navController)
        binding.navigationView.setNavigationItemSelectedListener(this)

        // Mostrar/ocultar drawer según la pantalla
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in topLevelDestinations) {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                binding.toolbar.visibility = View.VISIBLE
            } else {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                if (destination.id == R.id.splashFragment) {
                    binding.toolbar.visibility = View.GONE
                }
            }

            // Mostrar menú de administrador solo para usuarios con rol ADMIN
            val adminMenu = binding.navigationView.menu.findItem(R.id.nav_admin)
            adminMenu?.isVisible = sessionManager.isAdmin()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> navController.navigate(R.id.homeFragment)
            R.id.nav_books -> navController.navigate(R.id.booksFragment)
            R.id.nav_movies -> navController.navigate(R.id.moviesFragment)
            R.id.nav_profile -> navController.navigate(R.id.profileFragment)
            R.id.nav_admin -> navController.navigate(R.id.adminFragment)
            R.id.nav_logout -> {
                sessionManager.clearSession()
                navController.navigate(R.id.action_global_loginFragment)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}