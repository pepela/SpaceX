package com.pepela.remote

import androidx.lifecycle.LiveData
import com.pepela.data.launch.model.Launch
import com.pepela.data.launch.source.DataStore
import io.reactivex.Completable
import retrofit2.Call

class RemoteDataStoreImpl(val spaceXService: SpaceXService) : DataStore {
    override fun fetchLaunches(): Call<List<Launch>> =
            spaceXService.getLaunches()

    override fun getLaunches(): LiveData<List<Launch>> {
        TODO("not implemented")
    }

    override fun saveLaunches(launches: List<Launch>): Completable {
        TODO("not implemented")
    }

    override fun isCached(): Boolean {
        TODO("not implemented")
    }

}
