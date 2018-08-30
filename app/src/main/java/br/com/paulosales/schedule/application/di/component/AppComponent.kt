package br.com.paulosales.schedule.application.di.component

import android.app.Application
import br.com.paulosales.schedule.application.ScheduleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = [
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
