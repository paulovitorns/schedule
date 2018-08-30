package br.com.paulosales.schedule.ui.dashboard

import android.content.Context
import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.data.database.ScheduleDataBase
import br.com.paulosales.schedule.data.schedule.repository.DefaultScheduleRepository
import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource
import br.com.paulosales.schedule.data.schedule.repository.datasource.local.LocalScheduleDataSource
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import br.com.paulosales.schedule.domain.schedule.usecase.GetSchedules
import br.com.paulosales.schedule.domain.shared.SchedulesNotFoundException
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import io.reactivex.observers.DisposableSingleObserver

class DashBoardPresenter(
        schedulerProvider: SchedulerProvider,
        context: Context
) : RxBasePresenter<DashboardContract.View>(schedulerProvider),
        DashboardContract.Presenter {

    private val getSchedules: GetSchedules

    init {
        // Instance for DB
        val scheduleDB = ScheduleDataBase.getInstace(context)

        // Instance for local data source
        val localDataSource: ScheduleDataSource = LocalScheduleDataSource(scheduleDB.scheduleDao())

        // Instance for repository
        val scheduleRepository: ScheduleRepository = DefaultScheduleRepository(localDataSource)

        // Instance for use case
        getSchedules = GetSchedules(scheduleRepository)
    }

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
