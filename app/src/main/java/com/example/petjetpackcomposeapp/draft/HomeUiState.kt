package com.example.petjetpackcomposeapp.draft

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: String) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}