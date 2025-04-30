package com.example.petjetpackcomposeapp

sealed class HomeUiEvent {
    object LoadData : HomeUiEvent()
    object ButtonClicked : HomeUiEvent()
}
