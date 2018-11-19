package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.usecase.GetSchedules
import br.com.paulosales.schedule.domain.shared.SchedulesNotFoundException
import br.com.paulosales.schedule.ui.shared.BaseUi
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import javax.inject.Inject

@ActivityScope
class DashBoardPresenter @Inject constructor(
        schedulerProvider: SchedulerProvider,
        private val getSchedules: GetSchedules
) : RxBasePresenter<BaseUi>(schedulerProvider) {

    private val view: DashboardUI? get() = baseUi()

    fun loadSchedules() {
        executeFlowable(
                getSchedules.execute(),
                onNext = { schedules ->
                    updateSchedules(schedules)
                },
                onError = { error ->
                    errorOnFetchSchedules(error)
                }
        )
    }

    private fun updateSchedules(t: List<Schedule>) {
        view?.showSchedules(t)
    }

    private fun errorOnFetchSchedules(e: Throwable) {
        if (e is SchedulesNotFoundException) {
            view?.showEmptyState()
        } else {
            view?.showErrorMessage("An error occurs!")
        }
    }
}
