package com.prince.countdown.viewModel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private var timer: CountDownTimer? = null

    private val _currentTime = MutableStateFlow(totalTime)
    val currentTime: StateFlow<Long> = _currentTime

    private var _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private fun startTimer() {
        timer = object : CountDownTimer(totalTime, interval) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished
            }

            override fun onFinish() {
                _currentTime.value = totalTime
                _isRunning.value = false
            }
        }
    }

    fun onStartClicked() {
        startTimer()
        timer?.start()
        _isRunning.value = true
    }

    fun onResetClicked() {
        if (_isRunning.value) {
            timer?.cancel()
            _currentTime.value = totalTime
            _isRunning.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
        _currentTime.value = totalTime
    }

    companion object {
        const val totalTime = 20 * 1000L
        const val interval = 1000L
    }
}