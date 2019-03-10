package com.github.zeroicq.android_calendar.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zeroicq.android_calendar.databinding.MonthDayLayoutBinding

class MonthDaysAdapter() : RecyclerView.Adapter<MonthDaysAdapter.MonthDaysHolder>() {
    val DISPLAY_DAYS = 42 // 7 days * 6 weeks

    override fun getItemCount(): Int {
        return DISPLAY_DAYS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthDaysHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MonthDayLayoutBinding.inflate(inflater, parent, false)
        return MonthDaysHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MonthDaysHolder, pos: Int) {
//        Movie movie = Movie.ITEMS[position];
//        holder.binding.setMovie(movie);
        holder.binding?.monthDayTextView?.text = pos.toString()

    }

    class MonthDaysHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: MonthDayLayoutBinding? = DataBindingUtil.bind(v)

    }
}
