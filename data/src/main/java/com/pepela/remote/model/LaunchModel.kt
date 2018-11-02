package com.pepela.remote.model

import java.util.*

data class LaunchModel(val flight_number: Long,
                       val mission_name: String,
                       val launch_date_local: Date,
                       val launch_site: LaunchSiteModel,
                       val details: String?)
