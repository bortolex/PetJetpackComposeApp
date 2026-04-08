package com.example.petjetpackcomposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSearchViewModel @Inject constructor(val repository: UserRepository) : ViewModel() {

    val _listQueries/*: Flow<SearchUiState>*/ by lazy {
        MutableStateFlow(SearchUiState.Initial)
    }
    val searchResults = _listQueries.asStateFlow()
    var lastQuery: String = ""


    // Mutex or Channel
    fun searchUsers(query: String) {
        if (query.isEmpty() || lastQuery == query) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            delay(500)
//            Channel
            repository.searchUsers(query)
        }
    }


//    val flow: Flow<String> = apply {
//repository.searchUsers()
//    }
}