package br.com.paulosales.schedule.application

import br.com.paulosales.schedule.application.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ScheduleApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out ScheduleApp> {
        return DaggerAppComponent.builder()
                .application(this)
                .create(this)
    }

    companion object {
        @JvmStatic
        lateinit var instance: ScheduleApp
            private set
    }
}