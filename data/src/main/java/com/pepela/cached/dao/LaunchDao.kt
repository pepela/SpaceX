package com.pepela.cached.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pepela.cached.db.Constants.LAUNCH_TABLE_NAME
import com.pepela.cached.entity.LaunchEntity

@Dao
interface LaunchDao {
    @Query("SELECT * FROM $LAUNCH_TABLE_NAME")
    fun getLaunches(): LiveData<List<LaunchEntity>>

    @Insert
    fun insertAll(launchEntities: List<LaunchEntity>)

    @Query("SELECT COUNT(1) FROM $LAUNCH_TABLE_NAME")
    fun getLaunchesCount(): Boolean
}
