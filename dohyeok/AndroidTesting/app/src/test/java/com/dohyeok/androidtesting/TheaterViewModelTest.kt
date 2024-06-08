package com.dohyeok.androidtesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dohyeok.androidtesting.theater.TheaterViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TheaterViewModelTest {
    private lateinit var viewModel: TheaterViewModel

    /**
     * Rule: 테스트의 시작 전, 종료시에 정의된 작업들을 수행하도록 함
     *
     * InstantTaskExecutorRule : Android Components 의 작업들을 모두 한 스레드에서 동작하도록 하는 Rule
     */
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TheaterViewModel()
    }

    /**
     * ViewModel의 LiveData 테스트를 위해서 사전 작업이 필요함
     * - 테스트는 WorkerThread 에서 동작
     * - LiveData 의 setValue, getValue는 MainThread 에서 동작
     */
    @Test
    fun `요일변경테스트`() {
        // Given

        // When
        viewModel.changeDayOfWeekWithoutScope()

        // Then
        assertEquals(true, viewModel.isMonday.value)
    }


}