package com.koreatech.android_study

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.DayOfWeek


/**
 * @topic : 모바일 알림
 * @요구사항
 * - 티켓 가격
 *  - 12세 이하 : 15달러
 *  - 13세 ~ 60세 : 30달러
 *  - 61세 이상 : 20달러
 * - 영화 관람객의 나이가 100세 이상은 볼 수 없다.
 * - 할인
 *  - 10 % -> 13세 ~ 60세 -> 월
 *  - 20 % -> 12세 이하 -> 월
 *  - 50 % -> 60세 이상 -> 수
 **/

class MovieTest {
    private lateinit var movieUtils: MovieUtils

    @Before
    fun setUp() {
        movieUtils = MovieUtils()
    }

    @Test
    fun age_availableWatchMovie_ReturnTrue() {
        val age1 = 0
        val age2 = 1
        val age3 = 100
        val age4 = 101

        assertEquals(false, movieUtils.checkAge(age1))
        assertEquals(true, movieUtils.checkAge(age2))
        assertEquals(true, movieUtils.checkAge(age3))
        assertEquals(false, movieUtils.checkAge(age4))
    }

    @Test
    fun ageUnder12_watchMoviePrice_15() {
        val age = 12

        assertEquals(15, movieUtils.setPrice(age))
    }

    @Test
    fun ageBetween13to60_watchMoviePrice_30() {
        val age1 = 13
        val age2 = 60

        assertEquals(30, movieUtils.setPrice(age1))
        assertEquals(30, movieUtils.setPrice(age2))
    }

    @Test
    fun ageOver61_watchMoviePrice_20() {
        val age = 61

        assertEquals(20, movieUtils.setPrice(age))
    }

    @Test
    fun ageUnder12_hasMovieDiscount_ReturnTrue() {
        val age = 1
        val monday = DayOfWeek.MONDAY
        val tuesDay = DayOfWeek.TUESDAY

        assertEquals(true, movieUtils.hasDiscount(age, monday))
        assertEquals(false, movieUtils.hasDiscount(age, tuesDay))
    }

    @Test
    fun ageUnderBetween13to60_hasMovieDiscount_ReturnTrue() {
        val age = 13
        val age2 = 60
        val monday = DayOfWeek.MONDAY
        val tuesDay = DayOfWeek.TUESDAY

        assertEquals(true, movieUtils.hasDiscount(age, monday))
        assertEquals(false, movieUtils.hasDiscount(age, tuesDay))
        assertEquals(true, movieUtils.hasDiscount(age2, monday))
        assertEquals(false, movieUtils.hasDiscount(age2, tuesDay))
    }

    @Test
    fun ageOver61_hasMovieDiscount_ReturnTrue() {
        val age = 61
        val monday = DayOfWeek.MONDAY
        val tuesDay = DayOfWeek.TUESDAY
        val wednesDay = DayOfWeek.WEDNESDAY

        assertEquals(false, movieUtils.hasDiscount(age, monday))
        assertEquals(false, movieUtils.hasDiscount(age, tuesDay))
        assertEquals(true, movieUtils.hasDiscount(age, wednesDay))
    }

    @Test
    fun ageUnder12_discount_price12() {
        val age = 12

        val price = movieUtils.setPrice(age)
        val discount = movieUtils.setDiscount(age)
        val discountPrice = price - (price * (discount / 100f))

        assertEquals(12f, discountPrice)
    }

    @Test
    fun ageBetween13to60_discount_price27() {
        val age = 13

        val price = movieUtils.setPrice(age)
        val discount = movieUtils.setDiscount(age)
        val discountPrice = price - (price * (discount / 100f))

        assertEquals(27f, discountPrice)
    }

    @Test
    fun ageOver61_discount_price10() {
        val age = 61

        val price = movieUtils.setPrice(age)
        val discount = movieUtils.setDiscount(age)
        val discountPrice = price - (price * (discount / 100f))

        assertEquals(10f, discountPrice)
    }
}