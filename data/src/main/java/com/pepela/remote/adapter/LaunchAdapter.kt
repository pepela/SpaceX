package com.pepela.remote.adapter

import com.pepela.data.launch.model.Launch
import com.pepela.data.launch.model.LaunchSite
import com.pepela.remote.mapper.LaunchSiteMapper
import com.pepela.remote.model.LaunchModel
import com.pepela.remote.model.LaunchSiteModel
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson

class LaunchAdapter {
    val launchSiteMapper = LaunchSiteMapper()
    private val moshi = Moshi.Builder().build()
    private val launchSiteAdapter: JsonAdapter<LaunchSite> = moshi.adapter(LaunchSite::class.java)

    @FromJson
    fun fromJson(launchModel: LaunchModel): Launch {
        return Launch(launchModel.flight_number, launchModel.mission_name,
                launchModel.launch_date_local,
                launchSiteMapper.from(launchModel.launch_site), launchModel.details)
    }

    @ToJson
    fun toJson(launch: Launch): LaunchModel {
        return LaunchModel(launch.id, launch.name, launch.date,
                launchSiteAdapter.toJsonValue(launch.launchSite) as LaunchSiteModel, launch.details)
    }
}
