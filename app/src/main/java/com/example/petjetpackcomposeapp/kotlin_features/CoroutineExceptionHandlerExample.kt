package com.example.petjetpackcomposeapp.kotlin_features

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun examle1() { // not proper way to implement CoroutineExceptionHandler in simple job
    val scope = CoroutineScope(Job())

    scope.launch {                          // кореневий launch — CEH немає
        val handler = CoroutineExceptionHandler { _, e -> println("Caught: $e") }

        launch(handler) { // дочірній — CEH є, але не спрацює
            throw RuntimeException("oops")
        }
    }
}

fun examle2() { //  proper way to implement CoroutineExceptionHandler in simple job
    val scope = CoroutineScope(Job())
    val handler = CoroutineExceptionHandler { _, e -> println("Caught: $e") }
    scope.launch(handler) {
        launch() {
            throw RuntimeException("oops")
        }
    }
}