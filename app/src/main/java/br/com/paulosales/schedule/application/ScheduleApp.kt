package br.com.paulosales.schedule.application

import android.app.Application

class ScheduleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @JvmStatic
        lateinit var instance: ScheduleApp
            private set
    }
}