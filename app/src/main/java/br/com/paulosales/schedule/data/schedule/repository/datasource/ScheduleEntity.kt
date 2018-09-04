package br.com.paulosales.schedule.data.schedule.repository.datasource

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "schedule")
data class ScheduleEntity(
        @PrimaryKey
        @ColumnInfo(name = "schedule_id") var id: Long,
        @ColumnInfo(name = "schedule_title") var title: String = "",
        @ColumnInfo(name = "schedule_message") var message: String = "",
        @ColumnInfo(name = "schedule_datetime") var datetime: Long = System.currentTimeMillis(),
        @ColumnInfo(name = "schedule_should_have_notification") var shouldHaveNotification: Boolean = true,
        @ColumnInfo(name = "schedule_should_vibrate") var shouldVibrate: Boolean = true,
        @ColumnInfo(name = "schedule_should_play_sound") var shouldPlaySound: Boolean = true,
        @ColumnInfo(name = "schedule_already_displayed") var alreadyDisplayed: Boolean = false
)
