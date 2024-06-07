package com.koreatech.android_study

import java.time.LocalTime

class NotificationUtils {
    fun equalsReceiveTime(time: LocalTime) =
        time == LocalTime.of(9, 0) || time == LocalTime.of(18, 0)

    fun scopeReceiveTime(time: LocalTime) =
        time.isAfter(LocalTime.of(9, 0)) && time.isBefore(LocalTime.of(18, 0))

    fun receiveNotification(time: LocalTime) =
        equalsReceiveTime(time) || scopeReceiveTime(time)

    fun countNotification(count: Int): Int? = when {
        count == 0 -> 0
        count in 1..99 -> 1
        count >= 100 -> -1
        else -> null
    }

    fun setVolume(importance: NotificationImportance) = when (importance) {
        NotificationImportance.Low -> 1
        NotificationImportance.Mid -> 2
        NotificationImportance.High -> 3
    }
}

enum class NotificationImportance {
    Low, Mid, High
}
