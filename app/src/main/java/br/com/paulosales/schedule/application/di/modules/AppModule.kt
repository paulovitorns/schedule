package br.com.paulosales.schedule.application.di.modules

import android.app.Application
import android.content.Context
import br.com.paulosales.schedule.application.AppSchedulerProvider
import br.com.paulosales.schedule.application.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindScheduleProvider(
            appSchedulerProvider: AppSchedulerProvider
    ): SchedulerProvider
}
