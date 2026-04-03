package com.example.petjetpackcomposeapp.draft.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.draft.Item
import com.example.petjetpackcomposeapp.draft.ItemsRepository
import com.example.petjetpackcomposeapp.states.ScreenState
import com.example.petjetpackcomposeapp.states.UiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OldMainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repo: ItemsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ScreenState<List<Item>>>(ScreenState.Loading)
    val uiState: StateFlow<ScreenState<List<Item>>> = _uiState

    /**
     * approach when repo is invoked directly from ViewModel
     */
    fun load() = viewModelScope.launch {
        _uiState.value = ScreenState.Loading

        runCatching { repo.getItems() }
            .onSuccess { items ->
                _uiState.value =
                    if (items.isEmpty()) ScreenState.Empty("No items")
                    else ScreenState.Content(items)
            }
            .onFailure { e ->
                _uiState.value = ScreenState.Error(
                    message = UiText.Plain("plain"),
                    canRetry = true
                )
            }
    }
}
