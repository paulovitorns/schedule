package br.com.paulosales.schedule.application.di.component

import android.app.Application
import br.com.paulosales.schedule.application.ScheduleApp
import br.com.paulosales.schedule.application.di.modules.AppModule
import br.com.paulosales.schedule.application.di.modules.ScheduleRepositoryModule
import br.com.paulosales.schedule.ui.di.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            ScheduleRepositoryModule::class,
            ActivityBindingModule::class,
            AndroidSupportInjectionModule::class
        ]
)
interface AppComponent : AndroidInjector<ScheduleApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ScheduleApp>() {
        @BindsInstance
        abstract fun application(application: Application): Builder
    }
}
