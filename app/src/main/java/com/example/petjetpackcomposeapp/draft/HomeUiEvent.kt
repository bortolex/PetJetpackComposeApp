package com.example.petjetpackcomposeapp.draft

sealed class HomeUiEvent {
    object LoadData : HomeUiEvent()
    object ButtonClicked : HomeUiEvent()
}
