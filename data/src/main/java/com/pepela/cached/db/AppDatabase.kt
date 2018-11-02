package com.pepela.cached.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pepela.cached.converter.Converter
import com.pepela.cached.dao.LaunchDao
import com.pepela.cached.entity.LaunchEntity

@Database(entities = arrayOf(LaunchEntity::class), version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun launchDao(): LaunchDao
}
