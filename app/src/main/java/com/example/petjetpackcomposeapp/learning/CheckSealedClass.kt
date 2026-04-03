package com.example.petjetpackcomposeapp.learning

sealed class CheckSealedClass {
    data class CheckDataClassInterface(val s: String) : CheckSealedClass()
    data object Loading : CheckSealedClass()
    data object Failed : CheckSealedClass()
}