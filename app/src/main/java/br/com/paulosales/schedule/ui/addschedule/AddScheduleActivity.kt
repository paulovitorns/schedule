package br.com.paulosales.schedule.ui.addschedule

import android.os.Bundle
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.application.AppSchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseView

class AddScheduleActivity : BaseView<AddScheduleContract.Presenter>(),
        AddScheduleContract.View {

    override lateinit var presenter: AddScheduleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_schedule)

        setTitle("Add Schedule", true)
        presenter = AddSchedulePresenter(AppSchedulerProvider())
    }
}
