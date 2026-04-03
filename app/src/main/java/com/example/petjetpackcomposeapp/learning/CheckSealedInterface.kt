package com.example.petjetpackcomposeapp.learning

sealed interface CheckSealedInterface {

    data class CheckDataClassInterface(val s: String) : CheckSealedInterface
    data object Loading : CheckSealedInterface
    data object Failed : CheckSealedInterface

}

fun handleStateInterface(
    checkInterface: CheckInterface,
    checkSealedInterface: CheckSealedInterface
) {
    when(checkInterface){
        is CheckInterface.CheckDataClassInterface -> {}
    }

}