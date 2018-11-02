package com.pepela.data.launch.source


class DataStoreFactory(val remote: DataStore,
                       val local: DataStore) {

    fun getDataStore(isCached: Boolean): DataStore {
        return if (isCached) {
            getLocalData()
        } else {
            getRemoteData()
        }
    }

    fun getRemoteData(): DataStore = remote

    fun getLocalData(): DataStore = local

}
