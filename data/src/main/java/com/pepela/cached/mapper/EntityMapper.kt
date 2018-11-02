package com.pepela.cached.mapper

interface EntityMapper<Entity, Model> {
    fun from(entity: Entity): Model

    fun to(model: Model): Entity

    fun from(entities: List<Entity>): List<Model> =
            MutableList(entities.size) { from(entities[it]) }

    fun to(models: List<Model>): List<Entity> =
            MutableList(models.size) { to(models[it]) }
}
