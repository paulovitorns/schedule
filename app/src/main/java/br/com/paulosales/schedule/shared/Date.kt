package br.com.paulosales.schedule.shared

import java.util.Calendar
import java.util.Date

internal val calendar: Calendar by lazy {
    Calendar.getInstance()
}

val today: Date
    get() = calendar.time

fun Date.withDateTime(datetime: Long): Date {
    this.time = datetime
    calendar.time = this
    return calendar.time
}
