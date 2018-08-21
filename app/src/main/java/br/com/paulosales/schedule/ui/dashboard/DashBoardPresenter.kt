package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter

class DashBoardPresenter(schedulerProvider: SchedulerProvider) :
        RxBasePresenter<DashboardContract.View>(schedulerProvider),
        DashboardContract.Presenter {

    override var view: DashboardContract.View? = null

    override fun attachView(view: BaseContract.View) {
        view as DashboardContract.View
        this.view = view
    }
}
