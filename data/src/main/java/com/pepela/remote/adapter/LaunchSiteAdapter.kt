package com.pepela.remote.adapter

import com.pepela.data.launch.model.LaunchSite
import com.pepela.remote.model.LaunchSiteModel
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class LaunchSiteAdapter {
    @FromJson
    fun fromJson(launchSiteModel: LaunchSiteModel): LaunchSite =
            LaunchSite(launchSiteModel.site_id, launchSiteModel.site_name_long)

    @ToJson
    fun toJson(launchSite: LaunchSite): LaunchSiteModel =
            LaunchSiteModel(launchSite.id, launchSite.name)
}
