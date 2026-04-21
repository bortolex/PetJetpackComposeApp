package com.example.petjetpackcomposeapp.presentation.task2Raiffeisen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestViewModel: ViewModel() {


    /**   REQUIREMENTS:
     * What will happen when the following code is executed
     * viewModelScope.launch {
     *     launch {
     *          println("Hello")
     *          delay(100)
     *          println("World")
     *     }
     *
     *  try {
     *         launch {
     *            delay(50)
     *            throw Exception()
     *         }
     *      } catch (e: Exception) {
     *         println("Exception caught")
     *      }
     * }
     */


    fun testCode() {
        viewModelScope.launch {
            launch {
                println("Hello")
                delay(100)
                println("World")
            }

            try {
                launch {
                    delay(50)
                    throw Exception()
                }
            } catch (e: Exception) {
                println("Exception caught")
            }
        }
    }

}

/**
 * Hello
 * Exception caught
 */