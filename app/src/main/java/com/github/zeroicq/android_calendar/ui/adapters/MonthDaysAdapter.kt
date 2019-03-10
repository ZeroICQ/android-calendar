package com.github.zeroicq.android_calendar.ui.adapters

import android.databinding.DataBindingUtil
import android.support.constraint.Constraints
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.databinding.MonthDayLayoutBinding

class MonthDaysAdapter() : RecyclerView.Adapter<MonthDaysAdapter.MonthDaysHolder>() {
    val CELLS_NUMBER = 42 // 7 days * 6 weeks

    override fun getItemCount(): Int {
        return CELLS_NUMBER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthDaysHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MonthDayLayoutBinding.inflate(inflater, parent, false)
        return MonthDaysHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MonthDaysHolder, pos: Int) {
//        Movie movie = Movie.ITEMS[position];
//        holder.binding.setMovie(movie);
        holder.binding.monthDayTextView.text = pos.toString()
//        holder.binding.monthDayCl.setBackgroundColor(Color.rgb(pos * 20 % 255, pos * 10 % 255, pos * 3 % 255))

    }

    override fun onViewDetachedFromWindow(holder: MonthDaysHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.binding.unbind()
    }

    class MonthDaysHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: MonthDayLayoutBinding = DataBindingUtil.bind(v)!!

    }
}

