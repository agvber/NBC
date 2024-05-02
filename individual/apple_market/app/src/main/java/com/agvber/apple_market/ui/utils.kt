package com.agvber.apple_market.ui

import android.content.Intent
import android.os.Build

internal fun<T> Intent.getCustomParcelableExtra(
    name: String,
    clazz: Class<T>
): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(name, clazz)!!
    } else {
        getParcelableExtra(name)!!
    }
}