package com.example.petjetpackcomposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserSearchViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {

    private val queryChannel = Channel<String>(capacity = Channel.CONFLATED)
        // Channel.CONFLATED - this flag gives us possibility to take only last query
        private val _state = MutableStateFlow<SearchUiState>(SearchUiState.Initial)
        val state = _state.asStateFlow()

    private var debounceJob: Job? = null

    val _listQueries: MutableStateFlow<SearchUiState>/*: Flow<SearchUiState>*/ by lazy {
        MutableStateFlow(SearchUiState.Initial)
    }
    val searchResults = _listQueries.asStateFlow()
    var lastQuery: String = ""


    fun onQueryChanged(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            queryChannel.send(query)
        }
    }

    private fun observeQueries() {
        viewModelScope.launch {
            for (query in queryChannel) {

                // 🔴 cancel previous debounce
                debounceJob?.cancel()

                debounceJob = launch {
                    delay(500)

                    if (query.isBlank()) {
                        _state.value = SearchUiState.Initial
                        return@launch
                    }

                    _state.value = SearchUiState.Loading

                    try {
                        val result = withContext(Dispatchers.IO) {
                            repository.searchUsers(query)
                        }

                        _state.value = SearchUiState.Success(result)

                    } catch (e: Exception) {
                        _state.value = SearchUiState.Error(e.message ?: "Unknown error")
                    }
                }
            }
        }
    }

//    private fun observeQueries() {
//        viewModelScope.launch(Dispatchers.IO) {
//            var debounceJob: Job? = null
//
//            for (query in queryChannel) {
//                debounceJob?.cancel()
//
//                debounceJob = launch {
//                    delay(500)
//
//                    if (query.isBlank()) {
//                        println("Empty query, skip request")
//                        return@launch
//                    }
//
//                    try {
//                        val result = withContext(Dispatchers.IO) {
//                            repository.searchUsers(query)
//                        }
//                        println("Search result for '$query': $result")
//                    } catch (e: Exception) {
//                        println("Search error: ${e.message}")
//                    }
//                }
//            }
//        }
//    }


    // Mutex or Channel
    fun searchUsers(query: String) {
        if (query.isEmpty() || lastQuery == query) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            _listQueries.emit(SearchUiState.Loading)
//            Channel
            repository.searchUsers(query)
        }
    }


//    val flow: Flow<String> = apply {
//repository.searchUsers()
//    }
}