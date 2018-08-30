package br.com.paulosales.schedule.ui.dashboard

import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class DashBoardModule {
    @ActivityScope
    @Binds
    abstract fun dashboardPresenter(
            dashBoardPresenter: DashBoardPresenter
    ): DashboardContract.Presenter
}
