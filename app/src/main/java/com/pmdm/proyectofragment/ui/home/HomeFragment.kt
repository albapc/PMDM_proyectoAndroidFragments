package com.pmdm.proyectofragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pmdm.proyectofragment.R

class HomeFragment : Fragment() { //clase dedicada al homeFragment

    //crea objeto de la clase homeViewModel
    private lateinit var homeViewModel: HomeViewModel

    //método que crea el fragment y lo muestra
    override fun onCreateView(
        //variable de tipo LayoutInflater
        inflater: LayoutInflater,
        //variable de tipo ViewGroup
        container: ViewGroup?,
        //variable de tipo Bundle
        savedInstanceState: Bundle?
    ): View? {
        //llama a la clase HomeViewModel
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        //referencia/instancia un layout xml para poder utilizar las vistas dentro del mismo
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //asigna la variable al elemento textView utilizado en el layout
        val textView: TextView = root.findViewById(R.id.text_home)
        //crea una envoltura observable para nuestros datos en el textView
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root //devuelve el layout almacenado en la variable
    }
}
