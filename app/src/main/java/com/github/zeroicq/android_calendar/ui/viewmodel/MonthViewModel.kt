package com.github.zeroicq.android_calendar.ui.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import com.android.databinding.library.baseAdapters.BR
import com.github.zeroicq.android_calendar.data.DayModel
import com.github.zeroicq.android_calendar.data.repository.MonthTestRepository
import com.github.zeroicq.android_calendar.util.copyGregorian
import kotlin.collections.ArrayList

class MonthViewModel : BaseObservable() {
    private val MONTH_BUFFER_SIZE = 5
    private val DAYS_IN_MONTH_GRID_SIZE = 42


    var months = mutableListOf<ArrayList<DayModel>>()
    // current position in months list
    var pos: Int = MONTH_BUFFER_SIZE / 2

    @get:Bindable
    var toolbarTitle: String = "mm"
    set(value) {
        field = value
        notifyPropertyChanged(BR.toolbarTitle)
    }

    init {
        val now = GregorianCalendar.getInstance()
        val iterateDay = now.copyGregorian().apply { roll(Calendar.MONTH, -pos) }

        for (i in 1..MONTH_BUFFER_SIZE) {
            months.add(getDays(iterateDay))
            iterateDay.roll(Calendar.MONTH, true)
        }
    }

    private fun getDays(monthCalendar: GregorianCalendar) : ArrayList<DayModel> {
        val days = ArrayList<DayModel>()

        //todo: rmk
        val curMonthData = MonthTestRepository.get(monthCalendar)
        val prevMonthData = MonthTestRepository.get(monthCalendar.copyGregorian().apply { roll(Calendar.MONTH, false) })
        val nextMonthData = MonthTestRepository.get(monthCalendar.copyGregorian().apply { roll(Calendar.MONTH, true) })

        val firstDayOfMonth = GregorianCalendar(monthCalendar.get(Calendar.YEAR), monthCalendar.get(Calendar.MONTH), 1)

        var startIndex = firstDayOfMonth.get(Calendar.DAY_OF_WEEK)
        // remap indices
        startIndex -= 2
        if (startIndex < 0)
            startIndex = 6 + (startIndex + 1)

        val daysFromPrevMonth = startIndex - 1
        for (i in prevMonthData.lastIndex - daysFromPrevMonth..prevMonthData.lastIndex) {
            days.add(prevMonthData[i])
        }

        for (i in curMonthData) {
            days.add(i)
        }

        for ((nexMonthDataIndex, _) in (days.lastIndex until DAYS_IN_MONTH_GRID_SIZE).withIndex()) {
            days.add(nextMonthData[nexMonthDataIndex])
        }

        return days
    }



}