package br.com.paulosales.schedule.ui.dashboard

import android.content.Intent
import android.os.Bundle
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.application.AppSchedulerProvider
import br.com.paulosales.schedule.ui.addschedule.AddScheduleActivity
import br.com.paulosales.schedule.ui.shared.BaseView
import kotlinx.android.synthetic.main.activity_dash_board.fab

class DashBoardActivity : BaseView<DashboardContract.Presenter>(),
        DashboardContract.View {

    override lateinit var presenter: DashboardContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        setTitle("Your Schedules", false)
        presenter = DashBoardPresenter(AppSchedulerProvider())

        fab.setOnClickListener {
            startActivity(Intent(this, AddScheduleActivity::class.java))
        }
    }
}
