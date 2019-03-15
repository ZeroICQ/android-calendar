package com.github.zeroicq.android_calendar.data.repository

import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import com.github.zeroicq.android_calendar.data.DayModel
import kotlin.collections.ArrayList

class MonthTestRepository {

    companion object {
        fun get(calendar: Calendar) : ArrayList<DayModel> {
            val firstDay = calendar.getMinimum(Calendar.DAY_OF_MONTH)
            val lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            val days = ArrayList<DayModel>()

            for (i in firstDay..lastDay) {
                val dayDate = GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    i)


                days.add(DayModel(dayDate, "tst $i"))
            }
            return days
        }
    }
}