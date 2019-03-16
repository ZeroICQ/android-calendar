package com.github.zeroicq.android_calendar.util

import android.icu.util.Calendar
import android.icu.util.GregorianCalendar

fun Calendar.copyGregorian() : GregorianCalendar {
    return GregorianCalendar(
        this.get(Calendar.YEAR),
        this.get(Calendar.MONTH),
        this.get(Calendar.DATE)
    )
}