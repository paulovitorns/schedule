package br.com.paulosales.schedule.ui.editschedule

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseUi
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import javax.inject.Inject

class EditSchedulePresenter @Inject constructor(
        schedulerProvider: SchedulerProvider
) : RxBasePresenter<BaseUi>(schedulerProvider) {

    private val view: EditScheduleUi? get() = baseUi()

}
