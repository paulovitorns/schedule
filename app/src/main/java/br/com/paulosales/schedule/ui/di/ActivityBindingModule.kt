package br.com.paulosales.schedule.ui.di

import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import br.com.paulosales.schedule.ui.dashboard.DashBoardActivity
import br.com.paulosales.schedule.ui.dashboard.DashBoardModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [DashBoardModule::class])
    abstract fun dashboardActivity(): DashBoardActivity
}
