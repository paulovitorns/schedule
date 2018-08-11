package br.com.paulosales.schedule.data.schedule.repository

import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Completable
import io.reactivex.Single

class DefaultScheduleRepository(
        private val localDataSource: ScheduleDataSource
) : ScheduleRepository {
    override fun schedules(): Single<List<Schedule>> =
            localDataSource.fetchSchedules()

    override fun schedule(scheduleId: String): Single<Schedule> =
            localDataSource.fetchSchedule(scheduleId)

    override fun putSchedule(schedule: Schedule): Completable =
            localDataSource.insertSchedule(schedule)

    override fun updateSchedule(schedule: Schedule): Completable =
            localDataSource.updateSchedule(schedule)

    override fun setDisplayed(displayed: Boolean, scheduleId: String): Completable =
            localDataSource.setScheduleDisplayed(displayed, scheduleId)

    override fun deleteSchedule(scheduleId: String): Completable =
            localDataSource.deleteSchedule(scheduleId)

    override fun deleteSchedules(): Completable =
            localDataSource.deleteSchedules()
}
