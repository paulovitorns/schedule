package br.com.paulosales.schedule.domain.schedule.repository

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import io.reactivex.Completable
import io.reactivex.Single

interface ScheduleRepository {
    fun schedules(): Single<List<Schedule>>

    fun schedule(scheduleId: String): Single<Schedule>

    fun putSchedule(schedule: Schedule): Completable

    fun updateSchedule(schedule: Schedule): Completable

    fun setDisplayed(displayed: Boolean, scheduleId: String): Completable

    fun deleteSchedule(scheduleId: String): Completable

    fun deleteSchedules(): Completable
}
