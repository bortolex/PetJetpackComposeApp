package com.example.compose_navigation.navigation

import androidx.compose.runtime.Stable

@Stable
interface NavigationState {
    val isFirstScreen: Boolean
    val currentDestination: Destination
}