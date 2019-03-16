package com.github.zeroicq.android_calendar.data

import android.icu.util.Calendar


class DayModel(val date: Calendar, var message: String) {
    val dayNumber = date.get(Calendar.DAY_OF_MONTH)
}