package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.usecase.GetSchedules
import br.com.paulosales.schedule.domain.shared.SchedulesNotFoundException
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import io.reactivex.observers.DisposableSingleObserver

class DashBoardPresenter(
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
        executeSingle(getSchedules.execute(), ScheduleObserver())
    }

    inner class ScheduleObserver: DisposableSingleObserver<List<Schedule>>() {
        override fun onSuccess(t: List<Schedule>) {
            view?.showSchedules(t)
        }

        override fun onError(e: Throwable) {
            if (e is SchedulesNotFoundException) {
                view?.showEmptyState()
            } else {
                view?.showErrorMessage("An error occurs!")
            }
        }
    }
}
