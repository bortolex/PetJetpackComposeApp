package com.example.petjetpackcomposeapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petjetpackcomposeapp.domain.Character
import com.example.petjetpackcomposeapp.domain.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _state = MutableStateFlow<List<com.example.petjetpackcomposeapp.domain.Character>>(emptyList())
    val state: StateFlow<List<Character>> = _state

    init {
        viewModelScope.launch {
            repository.getCharacters().collect {
                _state.value = it
            }
        }
    }
}