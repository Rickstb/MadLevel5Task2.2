package com.example.madlevel5task2.utils

import androidx.room.TypeConverter
import java.time.LocalDate
import java.util.*

class Converters {
    @TypeConverter
    fun localDateToString(date: LocalDate): String {
        return date.toString()
    }

    @TypeConverter
    fun stringToLocalDate(dateString: String): LocalDate {
        return LocalDate.parse(dateString)
    }
}
