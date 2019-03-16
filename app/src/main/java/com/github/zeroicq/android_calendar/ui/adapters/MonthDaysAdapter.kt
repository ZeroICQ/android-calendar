package com.github.zeroicq.android_calendar.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.databinding.MonthDayLayoutBinding
import com.github.zeroicq.android_calendar.ui.viewmodel.MonthViewModel

class MonthDaysAdapter(var viewModel: MonthViewModel) : RecyclerView.Adapter<MonthDaysAdapter.MonthDaysHolder>() {
    //todo: rmk
//    val CELLS_NUMBER = 25 // 7 days * 6 weeks

    override fun getItemCount(): Int {
//        return viewModel.days.size
        return 42
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthDaysHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MonthDayLayoutBinding.inflate(inflater, parent, false)
        return MonthDaysHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MonthDaysHolder, pos: Int) {
        holder.binding.dayNumber = viewModel.months[viewModel.pos][pos].dayNumber.toString()
//        holder.binding.monthDayCl.setBackgroundColor(Color.rgb(pos * 20 % 255, pos * 10 % 255, pos * 3 % 255))
//        Movie movie = Movie.ITEMS[position];
//        holder.binding.setMovie(movie);
//        holder.binding.monthDayTextView.text = pos.toString()
//        holder.binding.dayModel = viewModel.days.getOrNull(pos)

    }

    override fun onViewDetachedFromWindow(holder: MonthDaysHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.binding.unbind()
    }

    class MonthDaysHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: MonthDayLayoutBinding = DataBindingUtil.bind(v)!!

    }
}

