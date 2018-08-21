package br.com.paulosales.schedule.ui.addschedule

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter

class AddSchedulePresenter(schedulerProvider: SchedulerProvider) :
        RxBasePresenter<AddScheduleContract.View>(schedulerProvider),
        AddScheduleContract.Presenter {

    override var view: AddScheduleContract.View? = null

    override fun attachView(view: BaseContract.View) {
        view as AddScheduleContract.View
        this.view = view
    }
}
