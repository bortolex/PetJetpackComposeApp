package com.example.navigation

interface Router {
    fun launch(route: Route)
    fun pop()
    fun restart(route: Route)
}