package com.pepela.remote.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.*

class DateAdapter {
    private val simpleDateFormat =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault())

    @FromJson
    fun formJson(date: String): Date =
            simpleDateFormat.parse(date)

    @ToJson
    fun toJson(date: Date): String =
            simpleDateFormat.format(date)
}
