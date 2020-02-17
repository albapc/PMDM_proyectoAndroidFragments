package com.pmdm.proyectofragment

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    /**
     * Método que se encarga de crear la MainActivity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //llamamos al método padre onCreate
        super.onCreate(savedInstanceState)
        //le asigna el contenido de esta activity
        setContentView(R.layout.activity_main)

        //asigna el set inferior de botones a una variable
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //asigna la pantalla principal (encima de los botones) a una variable
        val navController = findNavController(R.id.nav_host_fragment)

        /**
         * Pasamos los ids de cada menu como un set de ids para concretar las opciones a las cuales
         * se pueden acceder desde los botones inferiores
         */
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        /**
         * Asocia el control de los botones con la pantalla principal, para mostrar el menu
         * correspondiente
         */
        setupActionBarWithNavController(navController, appBarConfiguration)

        /**
         * Hace lo mismo que el setupActionBarWithNavController pero asociado con los botones en si
         * (los objetos)
         */
        navView.setupWithNavController(navController)
    }
}
