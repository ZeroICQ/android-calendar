package com.github.zeroicq.android_calendar.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.databinding.MonthLayoutBinding
import com.github.zeroicq.android_calendar.ui.custom.SpanGridLayoutManager
import com.github.zeroicq.android_calendar.ui.viewmodel.MonthViewModel


class MonthAdapter(var viewModel: MonthViewModel) : RecyclerView.Adapter<MonthAdapter.MonthHolder>() {

    override fun getItemCount() = viewModel.months.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MonthLayoutBinding.inflate(inflater, parent, false)
        val monthDaysGridViewManager = SpanGridLayoutManager(binding.root.context, 7)

        binding.monthRecyclerGridView.apply {
            adapter = MonthDaysAdapter(viewModel)
            layoutManager = monthDaysGridViewManager
            setHasFixedSize(true)
        }

        return MonthHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MonthHolder, pos: Int) {
        //todo: hach?
        viewModel.pos = pos
//        holder.binding.dayNumber = Random(pos).nextInt().toString()
//        holder.binding.monthDayCl.setBackgroundColor(Color.rgb(pos * 20 % 255, pos * 10 % 255, pos * 3 % 255))

    }

    override fun onViewDetachedFromWindow(holder: MonthHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.binding.unbind()
    }

    class MonthHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: MonthLayoutBinding = DataBindingUtil.bind(v)!!
    }
}