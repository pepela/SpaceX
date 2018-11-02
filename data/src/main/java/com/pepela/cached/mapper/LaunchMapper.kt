package com.pepela.cached.mapper

import com.pepela.cached.entity.LaunchEntity
import com.pepela.data.launch.model.Launch

class LaunchMapper(private val launchSiteMapper: LaunchSiteMapper)
    : EntityMapper<LaunchEntity, Launch> {
    override fun to(model: Launch): LaunchEntity =
            LaunchEntity(model.id, model.name, model.date, launchSiteMapper.to(model.launchSite),
                    model.details)

    override fun from(entity: LaunchEntity): Launch =
            Launch(entity.id, entity.name, entity.date, launchSiteMapper.from(entity.LaunchSite),
                    entity.details)

}
