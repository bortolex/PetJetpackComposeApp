package com.example.petjetpackcomposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StateFlowViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {

    private val _searchResultState: MutableStateFlow<SearchUiState> =
        MutableStateFlow(SearchUiState.Initial)
    val searchResultState = _searchResultState.asStateFlow()

    private val queryFlow = MutableStateFlow<String>("")

    init {
        observeResults()
    }

    fun onQueryChanged(query: String) {
        queryFlow.value = query
    }

    @OptIn(FlowPreview::class)
    private fun observeResults(){
        viewModelScope.launch {
            queryFlow.debounce(500).filter { it.isNotBlank() }.collectLatest {
                _searchResultState.value = SearchUiState.Loading
                val result = withContext(Dispatchers.IO) {
                    return@withContext repository.searchUsers(queryFlow.value)
                }
                _searchResultState.emit(SearchUiState.Success(result))
            }
        }
    }
}