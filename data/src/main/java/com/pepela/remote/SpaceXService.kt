package com.pepela.remote

import com.pepela.data.launch.model.Launch
import retrofit2.Call
import retrofit2.http.GET

interface SpaceXService {

    @GET("/v3/launches")
    fun getLaunches(): Call<List<Launch>>
}
