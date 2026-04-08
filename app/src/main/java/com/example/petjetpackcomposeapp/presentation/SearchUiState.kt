package com.example.petjetpackcomposeapp.presentation

sealed class SearchUiState {
    data object Initial : SearchUiState()
    data object Empty : SearchUiState()
    data class Success(val data: List<String>) : SearchUiState()
    data object Loading : SearchUiState()
}