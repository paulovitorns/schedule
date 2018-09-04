package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetSchedules @Inject constructor(private val repository: ScheduleRepository) {
    fun execute(): Flowable<List<Schedule>> = repository.schedules()
}
