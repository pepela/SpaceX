package com.pepela.data.launch.model

import java.util.*

data class Launch(val id: Long,
                  val name: String,
                  val date: Date,
                  val launchSite: LaunchSite,
                  val details: String?)
