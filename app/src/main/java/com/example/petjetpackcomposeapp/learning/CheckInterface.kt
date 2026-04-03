package com.example.petjetpackcomposeapp.learning

interface CheckInterface {
    data class CheckDataClassInterface(val s: String) : CheckInterface
    data object Loading : CheckInterface
    data object Failed : CheckInterface
}