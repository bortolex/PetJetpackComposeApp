package com.example.petjetpackcomposeapp.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository,
) : ViewModel() {

    val query = MutableStateFlow("")

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val results: StateFlow<SearchState> = query
        .debounce(500)
        .flatMapLatest { q ->
            flow {
                if (q.isBlank()) {
                    emit(SearchState.Idle)
                } else {
                    emit(SearchState.Loading)
                    val items = repository.search(q)
                    emit(SearchState.Success(items))
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SearchState.Idle,
        )

    fun onQueryChange(value: String) {
        query.value = value
    }
}

sealed class SearchState {
    data object Idle : SearchState()
    data object Loading : SearchState()
    data class Success(val items: List<String>) : SearchState()
}
