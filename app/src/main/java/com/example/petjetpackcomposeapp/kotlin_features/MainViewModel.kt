package com.example.petjetpackcomposeapp.kotlin_features

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    fun startWork() {

        viewModelScope.launch(
            CoroutineName("ParentCoroutine")
        ) {

            launch(
                CoroutineName("LoadUser")
            ) {
                loadUser()
            }

            launch(
                CoroutineName("LoadOrders")
            ) {
                loadOrders()
            }

            launch(
                CoroutineName("SyncData")
            ) {
                syncData()
            }
        }
    }

    private suspend fun loadUser() {
        val name = currentCoroutineContext()[CoroutineName]?.name
        Log.d(TAG, "START $name")
        delay(5_000)
        Log.d(TAG, "END $name")
    }

    private suspend fun loadOrders() {
        val name = currentCoroutineContext()[CoroutineName]?.name
        Log.d(TAG, "START $name")
        delay(10_000)
        Log.d(TAG, "END $name")
    }

    private suspend fun syncData() {
        val name = currentCoroutineContext()[CoroutineName]?.name
        Log.d(TAG, "START $name")
        delay(15_000)
        Log.d(TAG, "END $name")
    }

    companion object {
        private const val TAG = "coroutines in MainViewModel"
    }
}