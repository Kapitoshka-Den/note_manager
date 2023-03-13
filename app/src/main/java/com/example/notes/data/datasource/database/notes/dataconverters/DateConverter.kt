package com.example.notes.data.datasource.database.notes.dataconverters

import androidx.room.TypeConverter
import java.sql.Date
import java.time.LocalDate

class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}