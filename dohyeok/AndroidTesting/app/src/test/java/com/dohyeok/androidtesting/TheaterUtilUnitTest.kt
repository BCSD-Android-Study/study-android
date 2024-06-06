package com.dohyeok.androidtesting

import com.dohyeok.androidtesting.theater.TheaterUtil
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * 라인
 */
class TheaterUtilUnitTest {
    @Test
    fun given_월요일이고12세_when_티켓가격_then_15달러() {
        // Given
        val age = 12
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 15)
    }

    @Test
    fun given_월요일아니고12세_when_티켓가격_then_15달러() {
        // Given
        val age = 12
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 15)
    }

    @Test
    fun given_월요일이고13세_when_티켓가격_then_25달러() {
        // Given
        val age = 13
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 25)
    }

    @Test
    fun given_월요일아니고13세_when_티켓가격_then_30달러() {
        // Given
        val age = 13
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 30)
    }

    @Test
    fun given_월요일이고60세_when_티켓가격_then_25달러() {
        // Given
        val age = 60
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 25)
    }

    @Test
    fun given_월요일아니고60세_when_티켓가격_then_30달러() {
        // Given
        val age = 60
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 30)
    }

    @Test
    fun given_월요일이고61세_when_티켓가격_then_20달러() {
        // Given
        val age = 61
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 20)
    }

    @Test
    fun given_월요일아니고61세_when_티켓가격_then_20달러() {
        // Given
        val age = 61
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 20)
    }

    @Test
    fun given_월요일이고100세_when_티켓가격_then_20달러() {
        // Given
        val age = 100
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 20)
    }

    @Test
    fun given_월요일아니고100세_when_티켓가격_then_20달러() {
        // Given
        val age = 100
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, 20)
    }

    @Test
    fun given_월요일이고101세_when_티켓가격_then_마이너스1달러() {
        // Given
        val age = 101
        val isMonday = true

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, -1)
    }

    @Test
    fun given_월요일아니고101세_when_티켓가격_then_마이너스1달러() {
        // Given
        val age = 101
        val isMonday = false

        // When
        val price = TheaterUtil.ticketPrice(age, isMonday)

        // Then
        assertEquals(price, -1)
    }
}