package com.example.petjetpackcomposeapp.learning

sealed interface SealedInterface{

}

interface JustSimpleInterface {}

sealed class UIState {
    data class Success(val data: String) : UIState()
    data object Loading :
        UIState() // Тепер toString() поверне "Loading" data object Error : UIState()
}