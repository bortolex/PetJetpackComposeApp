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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SharedFlowViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {

    val _searchResultState: MutableStateFlow<SearchUiState> =
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
            queryFlow.debounce(500).collectLatest {
                _searchResultState.value = SearchUiState.Loading
                withContext(Dispatchers.IO){
                    val result = repository.searchUsers(queryFlow.value)
                }.apply {
                    _searchResultState.emit(SearchUiState.Success(it))
                }

            }
        }
    }


}