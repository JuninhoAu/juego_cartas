package com.juni.ola2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Sobreponer:RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(-180,0,0,0)

    }
}