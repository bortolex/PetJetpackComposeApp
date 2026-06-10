package com.example.petjetpackcomposeapp.kotlin_features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

//    override fun onLowMemory() {
//        super.onLowMemory()
//        // Скасовує всі запущені корутини, але САМ scope залишається активним!
//        applicationScope.coroutineContext.cancelChildren()
//    }


    fun simple() {
        viewModelScope.launch {
            delay(1000)
            nextCall()
        }
    }

    suspend fun nextCall(){
        delay(5000)
    }
}