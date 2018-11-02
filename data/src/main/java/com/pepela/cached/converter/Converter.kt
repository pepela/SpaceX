package com.pepela.cached.converter

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun fromDate(date: Date): Long = date.time

    @TypeConverter
    fun toDate(date: Long) = Date(date)
}
