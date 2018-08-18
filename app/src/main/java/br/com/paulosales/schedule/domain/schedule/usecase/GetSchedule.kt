package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Single

class GetSchedule(private val repository: ScheduleRepository) {
    fun execute(scheduleID: String): Single<Schedule> = repository.schedule(scheduleID)
}
