package com.koreatech.android_study

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalTime

/**
 * 유닛 테스트 고려사항
 * 1. 코드 분리 (순수 함수를 만든다.)
 * 2. 함수 외부 스코프의 값을 변경하지 않는다. (불필요한 사이드 이펙트는 예상하지 못한 오류를 야기할 수 있음)
 * 3. 함수 외부 스크포의 값을 참조하지 않는다. (함수 외부 영역에서 다른 것을 참조하는 것은 사이드 이펙트의 가능성을 내포하게 된다..)
 * 4. 함수 내부에서 함수의 결괏값에 영향을 주는 예측 불가능한 임의의 값을 사용하지 않는다. (Random 함수)
 */

/**
 * @topic : 모바일 알림
 * @요구사항
 * - 알림은 한국 시간 기준 오전 9시 ~ 오후 6시까지 알림을 수신할 수 있다.
 * - 알림은 한국 시간 기준 오전 9시 ~ 오후 6시 이외에 시간에는 알림을 수신할 수 없다.
 * - 알림 개수가 0개이면, 0 을 반환
 * - 알림 개수가 1~99개라면, 1 을 반환
 * - 알림 개수가 100개 이상이면, -1 을 반환
 * - 알림 중요도에 따라 알림 진동 세기가 다르다.
 *  - Low : 진동세기 1
 *  - Mid : 진동세기 2
 *  - High : 진동세기 3
 */
class NotificationTest {
    private lateinit var notificationUtils: NotificationUtils

    @Before
    fun setUp() {
        notificationUtils = NotificationUtils()
    }

    @Test
    fun startAndEndTime_equals_ReturnTrue() {
        val startTime = LocalTime.of(9, 0)
        val endTime = LocalTime.of(18, 0)

        assertEquals(true, notificationUtils.equalsReceiveTime(startTime))
        assertEquals(true, notificationUtils.equalsReceiveTime(endTime))
    }

    @Test
    fun startAndMiddleTime_scope_ReturnTrue() {
        val startTime = LocalTime.of(9, 0)
        val middleTime = LocalTime.of(9, 1)

        assertEquals(false, notificationUtils.scopeReceiveTime(startTime))
        assertEquals(true, notificationUtils.scopeReceiveTime(middleTime))
    }

    @Test
    fun scopeTime_receiveNotification_ReturnTrue() {
        val scopeTime1 = LocalTime.of(9, 0)
        val scopeTime2 = LocalTime.of(9, 1)
        val scopeTime3 = LocalTime.of(17, 59)
        val scopeTime4 = LocalTime.of(18, 0)

        assertEquals(true, notificationUtils.receiveNotification(scopeTime1))
        assertEquals(true, notificationUtils.receiveNotification(scopeTime2))
        assertEquals(true, notificationUtils.receiveNotification(scopeTime3))
        assertEquals(true, notificationUtils.receiveNotification(scopeTime4))
    }

    @Test
    fun count_countNotification_0() {
        val count = 0

        assertEquals(0, notificationUtils.countNotification(count))
    }

    @Test
    fun count_countNotification_1() {
        val count1 = 1
        val count2 = 56
        val count3 = 99

        assertEquals(1, notificationUtils.countNotification(count1))
        assertEquals(1, notificationUtils.countNotification(count2))
        assertEquals(1, notificationUtils.countNotification(count3))
    }

    @Test
    fun count_countNotification_minus1() {
        val count = 100

        assertEquals(-1, notificationUtils.countNotification(count))
    }

    @Test
    fun importanceLow_setVolume_1() {
        val importance = NotificationImportance.Low

        assertEquals(1, notificationUtils.setVolume(importance))
    }

    @Test
    fun importanceMid_setVolume_2() {
        val importance = NotificationImportance.Mid

        assertEquals(2, notificationUtils.setVolume(importance))
    }

    @Test
    fun importanceHigh_setVolume_3() {
        val importance = NotificationImportance.High

        assertEquals(3, notificationUtils.setVolume(importance))
    }
}