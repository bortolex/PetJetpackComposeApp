package com.example.petjetpackcomposeapp

sealed interface SealedInterfaceExample {
    object Loading : SealedInterfaceExample
    data class Success(val data: List<String>) : SealedInterfaceExample
    data class Error(val message: String) : SealedInterfaceExample
}