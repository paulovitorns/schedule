package br.com.paulosales.schedule.data.schedule.repository.datasource

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import io.reactivex.Completable
import io.reactivex.Single

interface ScheduleDataSource {
    fun fetchSchedules(): Single<List<Schedule>>

    fun fetchSchedule(scheduleId: String): Single<Schedule>

    fun insertSchedule(schedule: Schedule): Completable

    fun updateSchedule(schedule: Schedule): Completable

    fun setScheduleDisplayed(displayed: Boolean, scheduleId: String): Completable

    fun deleteSchedule(scheduleId: String): Completable

    fun deleteSchedules(): Completable
}