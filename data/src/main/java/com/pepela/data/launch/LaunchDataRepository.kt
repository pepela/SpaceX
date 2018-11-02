package com.pepela.data.launch

import androidx.lifecycle.LiveData
import com.pepela.data.launch.model.Launch
import com.pepela.data.launch.source.DataStoreFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchDataRepository(private val dataStoreFactory: DataStoreFactory) : LaunchRepository {
    override fun getLaunches(): LiveData<List<Launch>> {
        Single.fromCallable { dataStoreFactory.local.isCached() }
                .subscribeOn(Schedulers.io())
                .map {
                    if (!it) {
                        dataStoreFactory.remote.fetchLaunches()
                                .enqueue(object : Callback<List<Launch>> {
                                    override fun onFailure(call: Call<List<Launch>>, t: Throwable) {
                                        TODO("not implemented")
                                    }

                                    override fun onResponse(call: Call<List<Launch>>, response: Response<List<Launch>>) {
                                        if (response.code() == 200) {
                                            val launches = response.body()
                                            if (launches != null) {
                                                Single.fromCallable { dataStoreFactory.local.saveLaunches(launches) }
                                                        .subscribeOn(Schedulers.io())
                                                        .subscribe()

                                            }
                                        }
                                    }

                                })
                    }
                }
                .subscribe()

        return dataStoreFactory.local.getLaunches()

    }


}
