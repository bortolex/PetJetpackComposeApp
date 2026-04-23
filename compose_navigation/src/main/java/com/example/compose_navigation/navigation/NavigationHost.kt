package com.example.compose_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationHost(
    navigationHolder: NavigationHolder,
    modifier: Modifier,
    routeMapper: @Composable (Destination) -> Unit
) {
}