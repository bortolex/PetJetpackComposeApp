package com.example.petjetpackcomposeapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.HomeUiEvent
import com.example.petjetpackcomposeapp.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        handleEvent(HomeUiEvent.LoadData)
    }

    fun handleEvent(event: HomeUiEvent) {

        when (event) {
            is HomeUiEvent.LoadData -> {
                viewModelScope.launch {
                    delay(1000) // fake loading
                    _uiState.value = HomeUiState.Success("Hello from Home!")
                }
            }

            is HomeUiEvent.ButtonClicked -> {
                _uiState.value = HomeUiState.Success("Button was clicked!")
            }
        }
    }
}
