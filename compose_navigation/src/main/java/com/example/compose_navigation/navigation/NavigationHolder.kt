package com.example.compose_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember


@Stable
data class NavigationHolder(val routeManager: RouteManager,
                            val navigationState: NavigationState)

@Composable
fun rememberNavigation(initialDestination: Destination): NavigationHolder {
    return remember {
        val impl = NavigationStateImpl(initialDestination)
        NavigationHolder(
            routeManager = impl,
            navigationState = impl
        )
    }
}