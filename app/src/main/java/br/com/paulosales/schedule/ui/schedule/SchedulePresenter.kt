package br.com.paulosales.schedule.ui.schedule

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter

class SchedulePresenter(schedulerProvider: SchedulerProvider) :
        RxBasePresenter<ScheduleContract.View>(schedulerProvider),
        ScheduleContract.Presenter {

    override var view: ScheduleContract.View? = null

    override fun attachView(view: BaseContract.View) {
        view as ScheduleContract.View
        this.view = view
    }
}
