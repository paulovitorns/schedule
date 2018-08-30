package br.com.paulosales.schedule.data.schedule.repository.datasource.local

import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource
import br.com.paulosales.schedule.data.schedule.repository.datasource.mapper.toEntity
import br.com.paulosales.schedule.data.schedule.repository.datasource.mapper.toSchedule
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.shared.FailedToDeleteScheduleException
import br.com.paulosales.schedule.domain.shared.FailedToUpdateScheduleException
import br.com.paulosales.schedule.domain.shared.SchedulesNotFoundException
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalScheduleDataSource @Inject constructor(
        private val schedulesDao: SchedulesDao
) : ScheduleDataSource {

    override fun fetchSchedules(): Single<List<Schedule>> =
            schedulesDao.fetchSchedules().map { mapper ->
                if (mapper.isNotEmpty()) {
                    mapper.map {
                        it.toSchedule()
                    }
                } else {
                    throw SchedulesNotFoundException()
                }
            }

    override fun fetchSchedule(scheduleId: String): Single<Schedule> =
            schedulesDao.fetchSchedule(scheduleId).map { mapper ->
                mapper.toSchedule()
            }

    override fun insertSchedule(schedule: Schedule): Completable =
            Completable.create { emitter ->
                schedulesDao.insertSchedule(schedule.toEntity())
                emitter.onComplete()
            }

    override fun updateSchedule(schedule: Schedule): Completable =
            Completable.create { emitter ->
                val result = schedulesDao.updateSchedule(schedule.toEntity())
                if (result > 0) {
                    emitter.onComplete()
                } else {
                    emitter.onError(FailedToUpdateScheduleException())
                }
            }

    override fun setScheduleDisplayed(displayed: Boolean, scheduleId: String): Completable =
            Completable.create { emitter ->
                schedulesDao.updateDisplayed(displayed, scheduleId)
                emitter.onComplete()
            }

    override fun deleteSchedule(scheduleId: String): Completable =
            Completable.create { emitter ->
                val result = schedulesDao.deleteSchedule(scheduleId)
                if (result > 0) {
                    emitter.onComplete()
                } else {
                    emitter.onError(FailedToDeleteScheduleException())
                }
            }

    override fun deleteSchedules(): Completable =
            Completable.create { emitter ->
                schedulesDao.deleteSchedules()
                emitter.onComplete()
            }
}
