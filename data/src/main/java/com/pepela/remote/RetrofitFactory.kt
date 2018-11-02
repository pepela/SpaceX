package com.pepela.remote

import com.pepela.remote.adapter.DateAdapter
import com.pepela.remote.adapter.LaunchAdapter
import com.pepela.remote.adapter.LaunchSiteAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    fun createRetrofitService(): SpaceXService =
            Retrofit.Builder()
                    .baseUrl("https://api.spacexdata.com/")
                    .client(makeClient())
                    .addConverterFactory(MoshiConverterFactory.create(makeMoshi()))
                    //.addCallAdapterFactory(GsonConverterFactory.create(makeGson()))
                    .build()
                    .create(SpaceXService::class.java)

    fun makeClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(makeLoggingInterceptor())
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

    fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        HttpLoggingInterceptor.Level.BODY
        return logging
    }

    fun makeMoshi(): Moshi =
            Moshi.Builder()
                    .add(DateAdapter())
                    .add(LaunchSiteAdapter())
                    .add(LaunchAdapter())
                    .build()

}
