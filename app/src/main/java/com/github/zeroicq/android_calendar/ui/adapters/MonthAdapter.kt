package com.github.zeroicq.android_calendar.ui.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.databinding.MonthLayoutBinding
import com.github.zeroicq.android_calendar.ui.custom.SpanGridLayoutManager


class MonthAdapter(ctxt: Context) : RecyclerView.Adapter<MonthAdapter.MonthHolder>() {

    override fun getItemCount(): Int {
        //todo change
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MonthLayoutBinding.inflate(inflater, parent, false)
        return MonthHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MonthHolder, pos: Int) {
        val monthDaysGridViewManager = SpanGridLayoutManager(holder.binding.monthRecyclerGridView.context, 7)

        holder.binding.monthRecyclerGridView.apply {
            adapter = MonthDaysAdapter()
            layoutManager = monthDaysGridViewManager
            setHasFixedSize(true)
        }

//        holder.binding.monthDayCl.setBackgroundColor(Color.rgb(pos * 20 % 255, pos * 10 % 255, pos * 3 % 255))

    }

    class MonthHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: MonthLayoutBinding = DataBindingUtil.bind(v)!!
    }
}