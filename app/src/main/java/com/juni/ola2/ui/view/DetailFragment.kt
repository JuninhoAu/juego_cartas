package com.juni.ola2.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.juni.ola2.ui.viewmodel.ListViewModel
import com.juni.ola2.databinding.FragmentDetallesBinding


class DetailFragment : Fragment() {

    private val args:DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetallesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding= FragmentDetallesBinding.inflate(layoutInflater)

        val viewModel= ViewModelProvider(this).get(ListViewModel::class.java)

        viewModel.cartasList.observe(viewLifecycleOwner, Observer {

            list ->
            binding.detaimg01.setImageResource(list[args.carta01].location)
            binding.detaimg02.setImageResource(list[args.carta02].location)
            binding.detaimg03.setImageResource(list[args.carta03].location)

            binding.detatitle01.text=list[args.carta01].name
            binding.detatitle02.text=list[args.carta02].name
            binding.detatitle03.text=list[args.carta03].name


            binding.detades01.text=(list[args.carta01].description)
            binding.detades02.text=(list[args.carta02].description)
            binding.detades03.text=(list[args.carta03].description)

            binding.imghead01.setImageResource(list[args.carta01].location)
            binding.imghead02.setImageResource(list[args.carta02].location)
            binding.imghead03.setImageResource(list[args.carta03].location)

            binding.txthead01.text=list[args.carta01].name
            binding.txthead02.text=list[args.carta02].name
            binding.txthead03.text=list[args.carta03].name

        })

        binding.imgreturn.setOnClickListener {

            this.findNavController().popBackStack()
        }

        return binding.root


    }


}