package br.com.paulosales.schedule.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleEntity
import br.com.paulosales.schedule.data.schedule.repository.datasource.local.SchedulesDao

@Database(entities = [ScheduleEntity::class], version = 1)
abstract class ScheduleDataBase : RoomDatabase() {

    abstract fun scheduleDao(): SchedulesDao

    companion object {
        private var INSTANCE: ScheduleDataBase? = null

        private val lock = Any()

        fun getInstace(context: Context): ScheduleDataBase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ScheduleDataBase::class.java,
                            "ScheduleApp.db"
                    ).build()
                }

                return INSTANCE!!
            }
        }
    }
}
