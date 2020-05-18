package com.lylx.learn.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun dayDiff(startTime: Long, endTime: Long): Int {
    return try {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val cal = Calendar.getInstance()
        val day = sdf.format(Date(startTime))
        cal.time = sdf.parse(day)
        val time1 = cal.timeInMillis
        val cal2 = Calendar.getInstance()
        cal2.time = sdf.parse(sdf.format(Date(endTime)))
        val time2 = cal2.timeInMillis
        ((time2 - time1) / (1000 * 3600 * 24)).toInt()
    } catch (e: Exception) {
        0
    }
}

fun getDayDiff(startTimeStr: String, endTimeStr: String): Int {
    return try {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val startTime = format.parse(startTimeStr).time
        val endTime = format.parse(endTimeStr).time
        val diff = (endTime - startTime) / (1000 * 60 * 60 * 24)
        diff.toInt()
    } catch (e: ParseException) {
        e.printStackTrace()
        0
    }
}