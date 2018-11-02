package com.pepela.spacex.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.toReadableString(): String {
    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
    return simpleDateFormat.format(this)
}
