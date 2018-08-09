package br.com.paulosales.schedule.domain.schedule.model

import java.util.Date

data class Schedule(
        val scheduleTitle: String,
        val scheduleMessage: String,
        val isSchedule: Boolean,
        val scheduleDate: Date,
        val scheduleHaveNotification: Boolean,
        val notificationShouldVibrate: Boolean,
        val notificationShouldPlaySound: Boolean
)