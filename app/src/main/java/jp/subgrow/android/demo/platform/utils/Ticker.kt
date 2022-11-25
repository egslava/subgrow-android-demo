package jp.subgrow.android.demo.platform.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

object Ticker {
    fun CoroutineScope.ticker(
        delay_ms:
        Long,
    ) = flow {
        while (true) {
            emit(System.currentTimeMillis())
            delay(delay_ms)
        }
    }
}
