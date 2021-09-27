package com.juni.ola2

import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juni.ola2.databinding.FragmentMazoBinding


class MazoFragment : Fragment(),CustomListener {

    private lateinit var binding: FragmentMazoBinding
    private lateinit var adapter2: CustomAdapter
    private var listB= mutableListOf<Cartas>()

    private var cart01=999
    private var cart02=999
    private var cart03=999


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMazoBinding.inflate(layoutInflater)

        binding.recyclerView2.init( MutableList(25){index ->1 +index  })
        binding.img01.tag="ola1"
        binding.img01.setOnDragListener(dragListener)
        binding.img02.setOnDragListener(dragListener)
        binding.img03.setOnDragListener(dragListener)


        val viewModel=ViewModelProvider(this).get(ListViewModel::class.java)

        viewModel.cartasList.observe(viewLifecycleOwner, Observer {

            listB=it.toMutableList()

        })





        binding.btnext.setOnClickListener {


           val action=MazoFragmentDirections.actionMazoFragmentToDetallesFragment(cart01,cart02,cart03)
            findNavController().navigate(action)
        }









        return binding.root






    }


    private fun RecyclerView.init(ola:MutableList<Int> ) {

        this.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        adapter2= CustomAdapter(ola,this@MazoFragment)
        this.adapter=adapter2
        this.addItemDecoration(Sobreponer())
        this.setOnDragListener(adapter2.dragInstance)


    }


    private val dragListener = View.OnDragListener { v, event -> val receiverView: ImageView = v as ImageView

        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {

                true
            }

            DragEvent.ACTION_DRAG_ENTERED -> {



                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                true

            DragEvent.ACTION_DRAG_EXITED -> {



                true
            }

            DragEvent.ACTION_DROP -> {

                when {receiverView.tag!=null -> {

                    if(receiverView.tag as String=="ola1") {


                        if (receiverView.id==binding.img01.id){


                            val someInt = (0..21).shuffled().first()
                            cart01=listB[someInt].numero
                            binding.img01.tag="seleccionado"
                            binding.img01.setImageResource(listB[someInt].ubicacion)
                            listB.removeAt(someInt)
                            binding.img02.tag="ola1"
                            binding.txtv01.text= ""
                            binding.txtv02.text= getString(R.string.arrastrar)



                        }

                        if (receiverView.id==binding.img02.id){

                            val someInt = (0..20).shuffled().first()
                            cart02=listB[someInt].numero
                            binding.img02.setImageResource(listB[someInt].ubicacion)
                            listB.removeAt(someInt)
                            binding.img02.tag="seleccionado"
                            binding.img03.tag="ola1"
                            binding.txtv02.text= ""
                            binding.txtv03.text= getString(R.string.arrastrar)



                        }

                        if (receiverView.id==binding.img03.id){

                            val someInt = (0..19).shuffled().first()
                            cart03=listB[someInt].numero
                            binding.img03.setImageResource(listB[someInt].ubicacion)
                            listB.removeAt(someInt)
                            binding.txtv03.text= ""
                            binding.img03.tag="seleccionado"

                            binding.recyclerView2.visibility=View.GONE
                            binding.btnext.visibility=View.VISIBLE


                        }

                        adapter2.borrar()
                        v.invalidate()

                    }




                }
                }








                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {

                true
            }

            else -> {
                false
            }
        }
    }

    override fun setEmptyList(visibility: Int, recyclerView: Int, emptyTextView: Int) {
        TODO("Not yet implemented")
    }


}