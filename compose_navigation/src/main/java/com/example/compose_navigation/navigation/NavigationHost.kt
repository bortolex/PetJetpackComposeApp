package com.example.compose_navigation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationHost(
    navigationHolder: NavigationHolder,
    modifier: Modifier = Modifier,
    routeMapper: @Composable (Destination) -> Unit //it transforms routeNavigations into concrete Screen
) {
    Box(modifier = modifier) {
        routeMapper(navigationHolder.navigationState.currentDestination)
    }
}