package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.usecase.GetSchedules
import br.com.paulosales.schedule.domain.shared.SchedulesNotFoundException
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import javax.inject.Inject

@ActivityScope
class DashBoardPresenter @Inject constructor(
        schedulerProvider: SchedulerProvider,
        private val getSchedules: GetSchedules
) : RxBasePresenter<DashboardContract.View>(schedulerProvider),
        DashboardContract.Presenter {

    override var view: DashboardContract.View? = null

    override fun attachView(view: BaseContract.View) {
        view as DashboardContract.View
        this.view = view
    }

    override fun loadSchedules() {
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
