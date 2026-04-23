package com.example.compose_navigation.navigation

import androidx.compose.runtime.Stable

@Stable
interface RouteManager {
    fun open(destination: Destination)
    fun goBack()
    fun restart(destination: Destination)
//    fun add()
//    fun goBack()
//    fun delete()
//    fun last()
//    fun first()
}