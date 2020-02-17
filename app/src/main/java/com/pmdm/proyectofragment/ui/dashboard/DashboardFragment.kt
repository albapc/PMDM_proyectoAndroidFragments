package com.pmdm.proyectofragment.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pmdm.proyectofragment.R

class DashboardFragment : Fragment() { //clase dedicada al DashBoard Fragment

    //crea un objeto de la clase DasboardViewModel
    private lateinit var dashboardViewModel: DashboardViewModel

    //método que crea el fragment y lo muestra
    override fun onCreateView(
        //variable de tipo LayoutInflater
        inflater: LayoutInflater,
        //variable de tipo ViewGroup
        container: ViewGroup?,
        //variable de tipo Bundle
        savedInstanceState: Bundle?
    ): View? {
        //llama a la clase DashboardViewModel
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        //referencia/instancia un layout xml para poder utilizar las vistas dentro del mismo
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        //asigna la variable al elemento textView utilizado en el layout
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        //crea una envoltura observable para nuestros datos en el textView
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root //devuelve el layout almacenado en la variable
    }
}
