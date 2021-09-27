package com.juni.ola2

import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

 class DragListener internal constructor(private val listener: CustomListener) : View.OnDragListener {
    private var isDropped = false
    override fun onDrag(v: View, event: DragEvent): Boolean {
        when (event.action) {
            DragEvent.ACTION_DROP -> {
                isDropped = true
                var positionTarget = -1
                val viewSource = event.localState as View?
                val viewId = v.id
                val frameLayoutItem = R.id.frame_layout_item
                val emptyTextView1 = R.id.empty_list_text_view_1//mensaje si esta vacio
                val recyclerView2 = R.id.recycler_view_2//lista 2

                when (viewId) {frameLayoutItem, emptyTextView1, recyclerView2 -> {
                    val target: RecyclerView

                    when (viewId) {
                       // emptyTextView1, recyclerView1 -> target = v.rootView.findViewById<View>(recyclerView1) as RecyclerView
                        recyclerView2 -> target = v.rootView.findViewById<View>(recyclerView2) as RecyclerView
                        else -> {
                            target = v.parent as RecyclerView
                            positionTarget = v.tag as Int
                            Log.d("holax","else")

                        }
                    }
                   if (viewSource != null) {

                        Log.d("hola2"," viewsrouce difenrete de null")

                        //-------------SOURCE-------------------------------------------------//

                        val source = viewSource?.parent as RecyclerView
                        val adapterSource = source.adapter as CustomAdapter?
                        val positionSource = viewSource.tag as Int
                        val list: Int? = adapterSource?.getList()?.get(positionSource)
                        val listSource = adapterSource?.getList()?.apply {
                            removeAt(positionSource)
                            Log.d("holax"," remover")

                        }
                        listSource?.let {
                            adapterSource.updateList(it)
                            Log.d("holax","actualizar")

                        }
                        adapterSource?.notifyDataSetChanged()
                        //-------------TARGET-------------------------------------------------//
                        val adapterTarget = target.adapter as CustomAdapter?
                        val customListTarget = adapterTarget?.getList()
                        if (positionTarget >= 0) {
                            Log.d("holax"," mayor igual 0 let")

                            list?.let {
                                customListTarget?.add(positionTarget, it)
                                Log.d("holax"," mayor igual 0 let")

                            }
                            Log.d("holax"," mayor igual 0 ")

                        } else {

                            Log.d("holax"," MENOR QUE 0")


                            list?.let {
                                customListTarget?.add(it)
                                Log.d("holax"," MENOR QUE 0 LET")

                            }
                        }
                        customListTarget?.let {

                            adapterTarget.updateList(it)
                            Log.d("holax","actualizar raget")
                        }
                        adapterTarget?.notifyDataSetChanged()


                        if (source.id == recyclerView2 && adapterSource?.itemCount ?: 0 < 1) {
                            //listener.setEmptyList(View.VISIBLE, recyclerView2, emptyTextView2)
                        }
                        //if (viewId == emptyTextView2) {
                            // listener.setEmptyList(View.GONE, recyclerView2, emptyTextView2)
                        //}
                      //  if (source.id == recyclerView1 && adapterSource?.itemCount ?: 0 < 1) {
                            // listener.setEmptyList(View.VISIBLE, recyclerView1, emptyTextView1)
                        //}
                        if (viewId == emptyTextView1) {
                            // listener.setEmptyList(View.GONE, recyclerView1, emptyTextView1)
                        }
                   // }else{

                     //   Log.d("Hola2","else when")
                    }
                }else ->{
                    Log.d("hola2","fueraaa")
                }
                }
            }
        }
        if (!isDropped && event.localState != null) {
            Log.d("holax","is dorpperd")
            (event.localState as View).visibility = View.VISIBLE
        }
        return true
    }
}