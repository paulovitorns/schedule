package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Completable
import javax.inject.Inject

class PutSchedule @Inject constructor(private val repository: ScheduleRepository) {
    fun execute(schedule: Schedule): Completable = repository.putSchedule(schedule)
}
