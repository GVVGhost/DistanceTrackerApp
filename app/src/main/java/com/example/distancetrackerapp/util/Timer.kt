package com.example.distancetrackerapp.util

import kotlinx.coroutines.*

object Timer {

    fun startTimer(
        onStart: (initialTime: Int) -> Unit,
        onTick: (secondLeft: Int) -> Unit,
        onFinish: () -> Unit,
        @androidx.annotation.IntRange(from = 0, to = 60) seconds: Int = 10
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            withContext(Dispatchers.Main) { onStart(seconds) }
            for (i in seconds - 1 downTo 0) {
                delay(1000)
                withContext(Dispatchers.Main) { onTick(i) }
            }
            withContext(Dispatchers.Main) { onFinish() }
        }
    }
}