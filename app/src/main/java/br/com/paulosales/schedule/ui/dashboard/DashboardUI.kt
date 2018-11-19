package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.domain.schedule.model.Schedule
import br.com.paulosales.schedule.ui.shared.BaseUi

interface DashboardUI: BaseUi {
    fun showSchedules(schedules: List<Schedule>)
    fun showEmptyState()
    fun showErrorMessage(message: String)
}
