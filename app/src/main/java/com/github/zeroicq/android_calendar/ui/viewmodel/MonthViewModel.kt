package com.github.zeroicq.android_calendar.ui.viewmodel

import android.arch.lifecycle.ViewModel
import android.icu.util.Calendar
import com.github.zeroicq.android_calendar.data.DayModel
import kotlin.collections.ArrayList

class MonthViewModel() : ViewModel() {
    val days = ArrayList<DayModel>()
    init {
        val now = Calendar.getInstance()
        now.get(Calendar.MONTH)
        for (i in 0..41) {
            cl
        }
    }

}