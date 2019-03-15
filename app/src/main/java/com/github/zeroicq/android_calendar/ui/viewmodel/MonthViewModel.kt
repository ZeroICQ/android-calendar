package com.github.zeroicq.android_calendar.ui.viewmodel

import android.arch.lifecycle.ViewModel
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import com.github.zeroicq.android_calendar.data.DayModel
import com.github.zeroicq.android_calendar.data.repository.MonthTestRepository
import kotlin.collections.ArrayList

class MonthViewModel() : ViewModel() {
    var days = ArrayList<DayModel>()

    init {
        val now = GregorianCalendar.getInstance()
        val curMonthData = MonthTestRepository.get(now)

        now.get(Calendar.MONTH)

        val firstDayOfMonth = GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1)
        var startIndex = firstDayOfMonth.get(Calendar.DAY_OF_WEEK)

        startIndex -= 2
        if (startIndex < 0)
            startIndex = 6 + (startIndex + 1)

        for (i in 0..startIndex-1) {
            days.add(DayModel(now, "prev"))
        }

        var otherIndex = 0
        for (i in startIndex..now.getActualMaximum(Calendar.DAY_OF_MONTH) - 1) {
            days.add(curMonthData[otherIndex++])
        }
        for (i in otherIndex..41) {
            days.add(DayModel(now, "after"))
        }
    }

}