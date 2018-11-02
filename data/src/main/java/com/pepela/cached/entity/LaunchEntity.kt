package com.pepela.cached.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pepela.cached.db.Constants.LAUNCH_TABLE_NAME
import java.util.*

@Entity(tableName = LAUNCH_TABLE_NAME)
data class LaunchEntity(@PrimaryKey val id: Long,
                        val name: String,
                        val date: Date,
                        @Embedded(prefix = "launch_site_") val LaunchSite: LaunchSiteEntity,
                        val details: String?)

