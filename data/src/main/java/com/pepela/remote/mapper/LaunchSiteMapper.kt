package com.pepela.remote.mapper

import com.pepela.data.launch.model.LaunchSite
import com.pepela.remote.ModelMapper
import com.pepela.remote.model.LaunchSiteModel

class LaunchSiteMapper : ModelMapper<LaunchSiteModel, LaunchSite> {

    override fun from(model: LaunchSiteModel): LaunchSite =
            LaunchSite(model.site_id, model.site_name_long)

}
