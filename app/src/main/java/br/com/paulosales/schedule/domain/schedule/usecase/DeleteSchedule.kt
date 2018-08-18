package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Completable

class DeleteSchedule(private val repository: ScheduleRepository) {
    fun execute(scheduleID: String): Completable = repository.deleteSchedule(scheduleID)
}
