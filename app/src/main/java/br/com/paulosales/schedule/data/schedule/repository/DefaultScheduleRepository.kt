package br.com.paulosales.schedule.data.schedule.repository

import br.com.paulosales.schedule.data.schedule.repository.datasource.ScheduleDataSource
import br.com.paulosales.schedule.domain.schedule.repository.ScheduleRepository

class DefaultScheduleRepository(
        private val localDataSource: ScheduleDataSource
): ScheduleRepository