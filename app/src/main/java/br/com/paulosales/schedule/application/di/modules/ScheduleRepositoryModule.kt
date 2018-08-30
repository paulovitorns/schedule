package br.com.paulosales.schedule.application.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import br.com.paulosales.schedule.data.database.ScheduleDataBase
import br.com.paulosales.schedule.data.schedule.repository.DefaultScheduleRepository
import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource
import br.com.paulosales.schedule.data.schedule.repository.datasource.local.LocalScheduleDataSource
import br.com.paulosales.schedule.data.schedule.repository.datasource.local.SchedulesDao
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ScheduleRepositoryModule {

    @Singleton
    @Provides
    fun provideScheduleDB(context: Context): ScheduleDataBase = Room.databaseBuilder(
            context,
            ScheduleDataBase::class.java, DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideSchedulesDao(
            scheduleDataBase: ScheduleDataBase
    ): SchedulesDao = scheduleDataBase.scheduleDao()

    @Singleton
    @Provides
    fun provideLocalDataSource(
            schedulesDao: SchedulesDao
    ): ScheduleDataSource = LocalScheduleDataSource(schedulesDao)

    @Singleton
    @Provides
    fun provideScheduleRepository(
            dataSource: ScheduleDataSource
    ): ScheduleRepository = DefaultScheduleRepository(dataSource)
}

private const val DB_NAME = "ScheduleApp.db"
