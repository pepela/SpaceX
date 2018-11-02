package com.pepela.spacex.di

import androidx.room.Room
import com.pepela.cached.CachedDataStoreImpl
import com.pepela.cached.db.AppDatabase
import com.pepela.cached.mapper.LaunchMapper
import com.pepela.cached.mapper.LaunchSiteMapper
import com.pepela.data.launch.LaunchDataRepository
import com.pepela.data.launch.LaunchRepository
import com.pepela.data.launch.interactor.GetLaunchesUseCase
import com.pepela.data.launch.source.DataStore
import com.pepela.data.launch.source.DataStoreFactory
import com.pepela.remote.RemoteDataStoreImpl
import com.pepela.remote.RetrofitFactory
import com.pepela.spacex.launch.LaunchAdapter
import com.pepela.spacex.launch.LaunchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val applicationModule = module(override = true) {
    factory { LaunchSiteMapper() }
    factory { LaunchMapper(get()) }

    factory<LaunchRepository> { LaunchDataRepository(get()) }
    factory { RetrofitFactory.createRetrofitService() }
    single {
        Room.databaseBuilder(androidContext(),
                AppDatabase::class.java, "launches.db")
                .build()
    }
    factory<DataStore>("remote") { RemoteDataStoreImpl(get()) }
    factory<DataStore>("local") { CachedDataStoreImpl(get(), get()) }
    factory { DataStoreFactory(get("remote"), get("local")) }
}

val launchModule = module("launch", override = true) {
    factory { LaunchAdapter() }
    factory { GetLaunchesUseCase(get()) }
    viewModel { LaunchViewModel(get()) }
}
