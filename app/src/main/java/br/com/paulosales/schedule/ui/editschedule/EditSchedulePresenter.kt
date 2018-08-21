package br.com.paulosales.schedule.ui.editschedule

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseContract
import br.com.paulosales.schedule.ui.shared.RxBasePresenter

class EditSchedulePresenter(schedulerProvider: SchedulerProvider) :
        RxBasePresenter<EditScheduleContract.View>(schedulerProvider),
        EditScheduleContract.Presenter {

    override var view: EditScheduleContract.View? = null

    override fun attachView(view: BaseContract.View) {
        view as EditScheduleContract.View
        this.view = view
    }
}
