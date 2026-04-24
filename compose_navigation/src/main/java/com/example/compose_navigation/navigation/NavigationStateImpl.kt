package com.example.compose_navigation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

internal class NavigationStateImpl(initialDestination: Destination) : NavigationState, RouteManager {

    private var stack: List<Destination> by mutableStateOf(listOf(initialDestination))

    override val isFirstScreen: Boolean
        get() = stack.size <= 1

    override val currentDestination: Destination
        get() = stack.last()

    override fun open(destination: Destination) {
        stack = stack + destination
    }

    override fun goBack() {
        if (!isFirstScreen) {
            stack = stack.dropLast(1)
        }
    }

    override fun restart(destination: Destination) {
        stack = listOf(destination)
    }
}
