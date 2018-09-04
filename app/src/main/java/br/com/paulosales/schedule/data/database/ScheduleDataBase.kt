package br.com.paulosales.schedule.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleEntity
import br.com.paulosales.schedule.data.schedule.repository.datasource.local.SchedulesDao

@Database(
        entities = [ScheduleEntity::class],
        version = 1,
        exportSchema = false
)
abstract class ScheduleDataBase : RoomDatabase() {

    abstract fun scheduleDao(): SchedulesDao
}
