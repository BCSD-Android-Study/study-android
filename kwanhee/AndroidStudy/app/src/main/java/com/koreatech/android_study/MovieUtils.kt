package com.koreatech.android_study

import java.time.DayOfWeek

class MovieUtils {
    fun checkAge(age: Int) = when {
        age in 1..100 -> true
        else -> false
    }

    fun setPrice(age: Int): Int = when (age) {
        in 1..12 -> 15
        in 13..60 -> 30
        in 61..100 -> 20
        else -> 0
    }

    fun setDiscount(age: Int) = when(age) {
        in 1..12 -> 20
        in 13..60 -> 10
        in 61..100 -> 50
        else -> 0
    }

    fun hasDiscount(age: Int, dayOfWeek: DayOfWeek) = when (age) {
        in 1..12 -> {
            dayOfWeek == DayOfWeek.MONDAY
        }

        in 13..60 -> {
            dayOfWeek == DayOfWeek.MONDAY
        }

        in 61..100 -> {
            dayOfWeek == DayOfWeek.WEDNESDAY
        }

        else -> false
    }
}


