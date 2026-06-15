package com.example.petjetpackcomposeapp.kotlin_features

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val savedStateHandle: SavedStateHandle) : ViewModel() {

    val query: StateFlow<String> = savedStateHandle.getStateFlow("query", "")

    private val commands = listOf(
        LoadUserCommand(),
        LoadOrdersCommand(),
        SyncDataCommand(),
    )

    fun startWork() {
        Channel

        viewModelScope.launch(CoroutineName("ParentCoroutine")) {
            commands.forEach { command ->
                launch(command.coroutineName) {
                    command.execute()
                }
            }
        }
    }
}
