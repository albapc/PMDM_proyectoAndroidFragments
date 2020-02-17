package com.pmdm.proyectofragment.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    /**
     * El componente MutableLiveData se trata de una envoltura observable para nuestros datos
     * con la ventaja de que está asociado a un ciclo de vida (de un fragment o activity)
     */
    private val _text = MutableLiveData<String>().apply {
        value = "Este es el fragment del dashboard" //modifica el texto del fragment de notificaciones
    }
    val text: LiveData<String> = _text
}