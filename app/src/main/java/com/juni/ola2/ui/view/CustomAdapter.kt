package com.juni.ola2

import android.content.ClipData
import android.os.Build
import android.view.*
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.juni.ola2.ui.view.DragListener

interface CustomListener{ fun setEmptyList(visibility:Int,recyclerView: Int,emptyTextView: Int)
}

class CustomAdapter(private  var list: MutableList<Int>,private val listener:CustomListener?):RecyclerView.Adapter<CustomAdapter.CustomViewHolder?>(),View.OnTouchListener {

    var ola:Int=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return CustomViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int =list.size



    class CustomViewHolder(inflater: LayoutInflater,parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item,parent,false)){
        var frameLayout:FrameLayout?=null

        init {
            frameLayout=itemView.findViewById(R.id.frame_layout_item)
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.frameLayout?.tag=position
        holder.frameLayout?.setOnTouchListener(this)
        holder.frameLayout?.setOnDragListener(DragListener(listener!!))
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        ola= v?.tag as Int

        when(event?.action){

            MotionEvent.ACTION_DOWN ->{
                val data=ClipData.newPlainText("", "")
                val shadowBuilder=View.DragShadowBuilder(v)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data,shadowBuilder,v,0)
                }else{
                    v.startDrag(data,shadowBuilder,v,0)
                }
                return true
            }
        }

        return false

    }

    fun getList(): MutableList<Int> = this.list.toMutableList()

    fun updateList(list:MutableList<Int>){
        this.list= list
    }
    fun borrar(){

        list.removeAt(ola)
        updateList(list)
        notifyDataSetChanged()

    }

    val dragInstance: DragListener? get() = if (listener!=null){
        DragListener(listener)
    }else{
        null
    }




}