package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Single

class GetSchedules(private val repository: ScheduleRepository) {
    fun execute(): Single<List<Schedule>> = repository.schedules()
}
