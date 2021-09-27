package com.juni.ola2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.juni.ola2.databinding.FragmentDetallesBinding


class DetallesFragment : Fragment() {

    private val args:DetallesFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetallesBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding= FragmentDetallesBinding.inflate(layoutInflater)


        val viewModel= ViewModelProvider(this).get(ListViewModel::class.java)

        viewModel.cartasList.observe(viewLifecycleOwner, Observer {

            list ->
            binding.detaimg01.setImageResource(list[args.carta01].ubicacion)
            binding.detaimg02.setImageResource(list[args.carta02].ubicacion)
            binding.detaimg03.setImageResource(list[args.carta03].ubicacion)

            binding.detatitle01.text=list[args.carta01].nombre
            binding.detatitle02.text=list[args.carta02].nombre
            binding.detatitle03.text=list[args.carta03].nombre


            binding.detades01.text=(list[args.carta01].descri)
            binding.detades02.text=(list[args.carta02].descri)
            binding.detades03.text=(list[args.carta03].descri)

            binding.imghead01.setImageResource(list[args.carta01].ubicacion)
            binding.imghead02.setImageResource(list[args.carta02].ubicacion)
            binding.imghead03.setImageResource(list[args.carta03].ubicacion)

            binding.txthead01.text=list[args.carta01].nombre
            binding.txthead02.text=list[args.carta02].nombre
            binding.txthead03.text=list[args.carta03].nombre


        })

        binding.imgreturn.setOnClickListener {

            this.findNavController().popBackStack()

        }




        return binding.root


    }


}