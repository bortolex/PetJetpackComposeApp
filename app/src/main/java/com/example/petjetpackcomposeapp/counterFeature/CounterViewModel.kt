package com.example.petjetpackcomposeapp.counterFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.ui.effects.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterRepository: CounterRepository,
    private val router: Router,
) : ViewModel() {

    private val isIncrementInProgressFlow = MutableStateFlow(false)
    private val counterFlow = counterRepository.getCounterValue()

    val screenStateFlow = combine(counterFlow, isIncrementInProgressFlow, ::makeScreenState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = LoadResult.Loading,
        )

    fun increment() {
        viewModelScope.launch {
            isIncrementInProgressFlow.value = true
            counterRepository.increment()
            isIncrementInProgressFlow.value = false
        }
    }

    fun launchSettings() {
        router.launchSettings()
    }

    private fun makeScreenState(
        counterResult: LoadResult<Int>,
        isIncrementInProgress: Boolean,
    ): LoadResult<ScreenState> {
        return counterResult.map { counterValue ->
            ScreenState(counterValue, isIncrementInProgress)
        }
    }

    data class ScreenState(
        val counterValue: Int,
        val isIncrementInProgress: Boolean,
    )

}