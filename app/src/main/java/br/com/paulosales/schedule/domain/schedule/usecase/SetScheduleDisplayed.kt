package br.com.paulosales.schedule.domain.schedule.usecase

import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import io.reactivex.Completable

class SetScheduleDisplayed(private val repository: ScheduleRepository) {
    fun execute(displayed: Boolean, scheduleId: String): Completable =
            repository.setDisplayed(displayed, scheduleId)
}
