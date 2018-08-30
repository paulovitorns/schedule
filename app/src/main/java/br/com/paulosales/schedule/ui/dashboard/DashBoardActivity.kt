package br.com.paulosales.schedule.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.toast
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.ui.addschedule.AddScheduleActivity
import br.com.paulosales.schedule.ui.shared.BaseView
import kotlinx.android.synthetic.main.activity_dash_board.fab
import javax.inject.Inject

@ActivityScope
class DashBoardActivity : BaseView<DashboardContract.Presenter>(),
        DashboardContract.View {

    @Inject
    override lateinit var presenter: DashboardContract.Presenter
    private var schedules: ArrayList<Schedule> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        setTitle("Your Schedules", false)

        fab.setOnClickListener {
            navigateToAddSchedule()
        }

        createAdapter()
        presenter.loadSchedules()
    }

    private fun createAdapter() {

    }

    private fun navigateToAddSchedule() {
        startActivity(Intent(this, AddScheduleActivity::class.java))
    }

    override fun showSchedules(schedules: List<Schedule>) {

    }

    override fun showEmptyState() {}

    override fun showErrorMessage(message: String) {
        toast(message, Toast.LENGTH_LONG)
    }
}
