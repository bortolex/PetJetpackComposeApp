package com.example.petjetpackcomposeapp.learning.learning_sealed_interface

sealed interface UiState
sealed interface UiEvent
sealed interface Trackable{
    val eventName: String
}

sealed interface ScreenState : UiState {
    object Loading : ScreenState
    data class Success(val data: List<String>) : ScreenState
    data class Error(val message: String) : ScreenState
}

sealed interface ScreenEvent : UiEvent {

    data class ShowToast(val message: String) : ScreenEvent

    data class NavigateToDetails(val id: String) : ScreenEvent, Trackable {
        override val eventName: String = "navigate_to_details"
    }

    object Retry : ScreenEvent, Trackable {
        override val eventName: String = "retry_clicked"
    }
}