package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Completable

class DeleteSchedules(private val repository: ScheduleRepository) {
    fun execute(): Completable = repository.deleteSchedules()
}
