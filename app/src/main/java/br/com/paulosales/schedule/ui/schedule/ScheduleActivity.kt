package br.com.paulosales.schedule.ui.schedule

import android.os.Bundle
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.application.AppSchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseView

class ScheduleActivity : BaseView<ScheduleContract.Presenter>(),
        ScheduleContract.View {

    override lateinit var presenter: ScheduleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        setTitle("Schedule", false)
        presenter = SchedulePresenter(AppSchedulerProvider())
    }
}
