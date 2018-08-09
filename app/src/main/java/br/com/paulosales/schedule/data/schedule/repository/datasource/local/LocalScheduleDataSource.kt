package br.com.paulosales.schedule.data.schedule.repository.datasource.local

import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource

class LocalScheduleDataSource(
        private val schedulesDao: SchedulesDao
) : ScheduleDataSource