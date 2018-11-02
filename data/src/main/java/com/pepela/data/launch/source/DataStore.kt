package com.pepela.data.launch.source

import androidx.lifecycle.LiveData
import com.pepela.data.launch.model.Launch
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Call

interface DataStore {
    fun fetchLaunches(): Call<List<Launch>>

    fun getLaunches(): LiveData<List<Launch>>

    fun saveLaunches(launches: List<Launch>): Completable

    fun isCached(): Boolean

}
