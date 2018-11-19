package br.com.paulosales.schedule.ui.di

import br.com.paulosales.schedule.application.di.annotation.ActivityScope
import br.com.paulosales.schedule.ui.addschedule.AddScheduleActivity
import br.com.paulosales.schedule.ui.dashboard.DashBoardActivity
import br.com.paulosales.schedule.ui.editschedule.EditScheduleActivity
import br.com.paulosales.schedule.ui.schedule.ScheduleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun dashboardActivity(): DashBoardActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun addScheduleActivity(): AddScheduleActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun editScheduleActivity(): EditScheduleActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun scheduleActivity(): ScheduleActivity
}
