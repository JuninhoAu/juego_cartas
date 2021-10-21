package com.juni.ola2.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juni.ola2.R
import com.juni.ola2.model.Cartas

class ListViewModel:ViewModel() {

    private val _cartasList=MutableLiveData<MutableList<Cartas>>()
    val cartasList:LiveData<MutableList<Cartas>>
    get() = _cartasList

    init {
        fechCartas()
    }

    private fun fechCartas(){

        val list= mutableListOf<Cartas>()

        list.add(Cartas(0,"El Loco","el loco dasdsadad", R.drawable.loco))
        list.add(Cartas(1,"El Mago","el mago dasdsadad", R.drawable.mago))
        list.add(Cartas(2,"La Sacerdotisa","la sacerdotisa dasdsadad", R.drawable.sacerdotisa))
        list.add(Cartas(3,"La Emperatriz","el emperatirs dasdsadad", R.drawable.emperatriz))
        list.add(Cartas(4,"El Emperador","el empedaro dasdsadad", R.drawable.emperador))

        list.add(Cartas(5,"El Sumo sacerdote","el sumo dasdsadad", R.drawable.sacerdote))
        list.add(Cartas(6,"Los Enamorados","los enamorados loco dasdsadad", R.drawable.enamorados))
        list.add(Cartas(7,"El Carro","el carro dasdsadad", R.drawable.carro))
        list.add(Cartas(8,"La Justicia","la justicia dasdsadad", R.drawable.justicia))
        list.add(Cartas(9,"Hermanito","el hermanito dasdsadad", R.drawable.hermanito))

        list.add(Cartas(10,"Rueda de la Fortuna","la rueda de la foruna dasdsadad",
            R.drawable.rueda
        ))
        list.add(Cartas(11,"La Fuerza","la fuerza dasdsadad", R.drawable.fuerza))
        list.add(Cartas(12,"El Colgado","el colgado dasdsadad", R.drawable.colgado))
        list.add(Cartas(13,"La Muerte","la muerte dasdsadad", R.drawable.muerte))
        list.add(Cartas(14,"La Templanza","la templanza dasdsadad", R.drawable.templanza))

        list.add(Cartas(15,"El diablo","el diablo dasdsadad", R.drawable.diablo))
        list.add(Cartas(16,"La torre","la torre dasdsadad", R.drawable.torre))
        list.add(Cartas(17,"La estrella","la estrella dasdsadad", R.drawable.estrella))
        list.add(Cartas(18,"La luna","la luna dasdsadad", R.drawable.luna))
        list.add(Cartas(19,"El sol","el sol dasdsadad", R.drawable.sol))
        list.add(Cartas(20,"El juicio","el juicio dasdsadad", R.drawable.juicio))
        list.add(Cartas(21,"El mundo","el mundo dasdsadad", R.drawable.mundo))

       _cartasList.value=list



    }


}