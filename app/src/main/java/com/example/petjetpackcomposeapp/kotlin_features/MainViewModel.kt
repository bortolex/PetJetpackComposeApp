package com.example.petjetpackcomposeapp.kotlin_features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val commands = listOf(
        LoadUserCommand(),
        LoadOrdersCommand(),
        SyncDataCommand(),
    )

    fun startWork() {
        viewModelScope.launch(CoroutineName("ParentCoroutine")) {
            commands.forEach { command ->
                launch(command.coroutineName) {
                    command.execute()
                }
            }
        }
    }
}
