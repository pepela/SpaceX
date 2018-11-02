package com.pepela.cached.mapper

import com.pepela.cached.entity.LaunchSiteEntity
import com.pepela.data.launch.model.LaunchSite


class LaunchSiteMapper : EntityMapper<LaunchSiteEntity, LaunchSite> {
    override fun to(model: LaunchSite): LaunchSiteEntity = LaunchSiteEntity(model.id, model.name)

    override fun from(entity: LaunchSiteEntity): LaunchSite = LaunchSite(entity.id, entity.name)
}
