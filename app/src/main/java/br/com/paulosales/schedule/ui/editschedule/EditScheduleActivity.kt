package br.com.paulosales.schedule.ui.editschedule

import android.os.Bundle
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.application.AppSchedulerProvider
import br.com.paulosales.schedule.ui.shared.BaseView

class EditScheduleActivity : BaseView<EditScheduleContract.Presenter>(),
        EditScheduleContract.View {

    override lateinit var presenter: EditScheduleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_schedule)

        setTitle("Schedule", false)
        presenter = EditSchedulePresenter(AppSchedulerProvider())
    }
}
