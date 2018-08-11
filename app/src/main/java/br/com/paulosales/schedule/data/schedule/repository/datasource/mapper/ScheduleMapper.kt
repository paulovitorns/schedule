package br.com.paulosales.schedule.data.schedule.repository.datasource.mapper

import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleEntity
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.shared.toDate

fun ScheduleEntity.toSchedule(): Schedule = Schedule(
        scheduleTitle = this.title,
        scheduleMessage = this.message,
        isSchedule = !this.alreadyDisplayed,
        scheduleDate = this.datetime.toDate(),
        scheduleHaveNotification = this.shouldHaveNotification,
        notificationShouldVibrate = this.shouldVibrate,
        notificationShouldPlaySound = this.shouldPlaySound
)

fun Schedule.toEntity(): ScheduleEntity = ScheduleEntity(
        title = this.scheduleTitle,
        message = this.scheduleMessage,
        datetime = this.scheduleDate.time,
        shouldHaveNotification = this.scheduleHaveNotification,
        shouldVibrate = this.notificationShouldVibrate,
        shouldPlaySound = this.notificationShouldPlaySound
)
