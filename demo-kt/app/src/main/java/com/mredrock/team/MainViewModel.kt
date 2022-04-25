package com.mredrock.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 *@author ZhiQiang Tu
 *@time 2022/4/20  16:43
 *@signature 我将追寻并获取我想要的答案
 */
class MainViewModel : ViewModel() {

    private val _event = MutableSharedFlow<MainEvent>()
    val event: SharedFlow<MainEvent> = _event

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Idle)
    val state: StateFlow<MainState> = _state


    fun renderIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.ButtonClicked -> {
                buttonClicked()
            }
        }
    }

    private fun buttonClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            _event.emit(MainEvent.Toast("Loading..."))
            var progress = 0f
            while (progress < 1.0) {
                val random = Random.nextDouble(0.0, 0.1)
                progress += (0.01f + random.toFloat())
                _state.value = MainState.Loading(progress)
                delay(1000)
            }

            _state.value = MainState.Finished
            _event.emit(MainEvent.Toast("Finished..."))
        }
    }


}

sealed class MainEvent {
    class Toast(val text: String) : MainEvent()
}

sealed class MainState {
    object Idle : MainState()

    class Loading(
        val progress: Float,
    ) : MainState()

    object Finished : MainState()
}

sealed class MainIntent {
    object ButtonClicked : MainIntent()
}