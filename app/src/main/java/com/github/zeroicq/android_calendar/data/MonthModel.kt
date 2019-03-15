package com.github.zeroicq.android_calendar.data

class MonthModel(val days: ArrayList<DayModel>)

class MonthModelBuilder() {
    var days = ArrayList<DayModel>()

    fun add(dayModel : DayModel) {
        days.add(dayModel)
    }

    fun build(): ArrayList<DayModel> = days

}