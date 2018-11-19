package br.com.paulosales.schedule.ui.schedule

import br.com.paulosales.schedule.application.SchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseUi
import br.com.paulosales.schedule.ui.shared.RxBasePresenter
import javax.inject.Inject

class SchedulePresenter @Inject constructor(
        schedulerProvider: SchedulerProvider
) : RxBasePresenter<BaseUi>(schedulerProvider) {

    private val view: ScheduleUi? get() = baseUi()
}
