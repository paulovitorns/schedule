package br.com.paulosales.schedule.shared

import java.util.Date

fun Long.toDate(): Date = Date().withDateTime(this)
