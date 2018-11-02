package com.pepela.remote

interface ModelMapper<in Model, out Entity> {
    fun from(model: Model): Entity

    fun from(models: List<Model>): List<Entity> = MutableList(models.size) { from(models[it]) }
}
