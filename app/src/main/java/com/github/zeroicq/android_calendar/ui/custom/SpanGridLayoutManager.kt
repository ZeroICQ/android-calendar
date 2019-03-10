package com.github.zeroicq.android_calendar.ui.custom

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.ViewGroup

class SpanGridLayoutManager(ctxt: Context, spanCount: Int) : GridLayoutManager(ctxt, spanCount) {
    override fun canScrollVertically() = false

    override fun canScrollHorizontally() = false

    private fun spanLayoutSize(layoutParams: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        if (orientation == HORIZONTAL) {
            layoutParams.width = Math.round(getHorizontalSpace()/Math.ceil((itemCount / spanCount).toDouble())).toInt()
        }
        else if(orientation == VERTICAL) {
            layoutParams.height = Math.round(getVerticalSpace()/Math.ceil((itemCount / spanCount).toDouble())).toInt()
        }
        return layoutParams
    }

    private fun getHorizontalSpace() = width - paddingRight - paddingLeft
    private fun getVerticalSpace() = height - paddingBottom - paddingTop

    override fun generateLayoutParams(c: Context?, attrs: AttributeSet?): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(c, attrs))
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams?): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(lp))
    }
}