package com.pepela.spacex

import android.app.Application
import com.pepela.spacex.di.applicationModule
import com.pepela.spacex.di.launchModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(applicationModule, launchModule))
    }

}
