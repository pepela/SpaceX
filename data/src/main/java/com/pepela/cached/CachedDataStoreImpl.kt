package com.pepela.cached

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.pepela.cached.db.AppDatabase
import com.pepela.cached.mapper.LaunchMapper
import com.pepela.data.launch.model.Launch
import com.pepela.data.launch.source.DataStore
import io.reactivex.Completable
import retrofit2.Call

class CachedDataStoreImpl(private val database: AppDatabase,
                          private val launchMapper: LaunchMapper) : DataStore {

    override fun fetchLaunches(): Call<List<Launch>> {
        TODO("not implemented")
    }

    override fun getLaunches(): LiveData<List<Launch>> =
            Transformations.map(database.launchDao().getLaunches())
            {
                launchMapper.from(it)
            }

    override fun saveLaunches(launches: List<Launch>): Completable {
        database.launchDao().insertAll(launchMapper.to(launches))
        return Completable.complete()
    }

    override fun isCached(): Boolean =
            database.launchDao().getLaunchesCount()

}
