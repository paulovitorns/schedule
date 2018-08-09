package br.com.paulosales.schedule.data.schedule.repository.datasource.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleEntity
import io.reactivex.Flowable

@Dao
interface SchedulesDao {

    @Query("SELECT * FROM schedule")
    fun fetchSchedules(): Flowable<List<ScheduleEntity>>

    @Query("SELECT * FROM schedule WHERE schedule_id = :scheduleId")
    fun fetchSchedule(scheduleId: String): Flowable<ScheduleEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchedule(schedule: ScheduleEntity)

    @Update
    fun updateSchedule(schedule: ScheduleEntity): Int

    @Query("UPDATE schedule SET schedule_already_displayed = :displayed WHERE schedule_id = :scheduleId")
    fun updateDisplayed(displayed: Boolean, scheduleId: String)

    @Query("DELETE FROM schedule WHERE schedule_id = :scheduleId")
    fun deleteTask(scheduleId: String): Int

    @Query("DELETE FROM schedule")
    fun deleteTasks()
}
