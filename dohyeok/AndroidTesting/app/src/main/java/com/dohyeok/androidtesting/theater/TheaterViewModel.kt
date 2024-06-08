package com.dohyeok.androidtesting.theater

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TheaterViewModel : ViewModel() {
    private val _isMonday: MutableLiveData<Boolean> = MutableLiveData(false)
    val isMonday: LiveData<Boolean> get() = _isMonday

    fun changeDayOfWeek() {
        viewModelScope.launch {
            _isMonday.value?.let{
                _isMonday.value = !it
            }
        }
    }
}