package com.example.petjetpackcomposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChannelViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {
    val channelQueries: Channel<String> =
        Channel(capacity = Channel.CONFLATED)// conflated means that only last one will be taken from channel
    val _searchResults = MutableStateFlow<SearchUiState>(SearchUiState.Initial)
    val searchResults = _searchResults.asStateFlow()
    var debounceJob: Job? = null

    fun onQueryChanged(query: String) {
        //send query to channel
        viewModelScope.launch { channelQueries.send(query) }
    }

    init {
        observeSearchResults()
    }

    // https://chatgpt.com/c/69d7b5be-899c-8393-89ab-cabd74ee05f7
    // глянути як зробити через SharedFlow
    fun observeSearchResults() {
        viewModelScope.launch {
            debounceJob = launch {
                for (query in channelQueries){
                    debounceJob?.cancel()
                    delay(500)
                    _searchResults.emit(SearchUiState.Loading)
                    val result = withContext(Dispatchers.IO) {
                        repository.searchUsers(query)
                    }
                    _searchResults.emit(SearchUiState.Success(data = result))
                }
            }
        }
    }
}