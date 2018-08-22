package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.ui.shared.BaseContract

interface DashboardContract {
    interface Presenter : BaseContract.Presenter {
        fun loadSchedules()
    }

    interface View : BaseContract.View {
        fun showSchedules(schedules: List<Schedule>)
        fun showEmptyState()
        fun showErrorMessage(message: String)
    }
}
