package com.example.petjetpackcomposeapp.counterFeature

import com.example.petjetpackcomposeapp.counterFeature.LoadResult.Success
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Int.Companion.MAX_VALUE

@Singleton
class CounterRepository @Inject constructor() {

    private val _counterFlow = MutableStateFlow(0)

    fun getCounterValue(): Flow<LoadResult<Int>> {
        val loadResultFlow: Flow<LoadResult<Int>> = _counterFlow.map(::Success)
        return loadResultFlow.onStart {
            emit(LoadResult.Loading)
            delay(2000)
        }
    }

    suspend fun increment() {
        delay(2000)
        _counterFlow.update { oldValue ->
            (oldValue + 1).takeIf { it <= MAX_VALUE } ?: 0
        }
    }

    suspend fun set(value: String){
        delay(2000)
        val parsedValue = value.toIntOrNull()?:throw InvalidCounterValueException(value)
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 1_000_000
    }


}