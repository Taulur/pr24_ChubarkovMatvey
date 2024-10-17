package com.bignerdranch.android.navigation2024_marininasvetlana

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Получаем navController
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return
        val navController = host.navController

        // Настройка бокового меню
        val sideBar = findViewById<NavigationView>(R.id.navigation_view)
        sideBar.setupWithNavController(navController)

        // Настройка панели инструментов
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        drawerLayout = findViewById(R.id.drawerLayout)
        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar) // Устанавливаем Toolbar как ActionBar
        setupActionBarWithNavController(navController, appBarConfiguration) // Настраиваем ActionBar с NavController
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView) // Получаем NavController
        return navController.navigateUp() || super.onSupportNavigateUp() // Да - предудщий экран. Нет - закрыть активность
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)

        // Обработка нажатия кнопки гамбургера
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START) // Открываем боковое меню
            return true
        }
//ажата ли кнопка гамбургера
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}















