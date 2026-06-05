package com.example.petjetpackcomposeapp.ui.navigation.multiplestacks

import android.accessibilityservice.GestureDescription
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

 val TOP_LEVEL_ROUTES = mapOf<NavKey, NavBarItem>(
    RouteA to NavBarItem(icon = Icons.Default.Home, description = "Route A"),
    RouteB to NavBarItem(icon = Icons.Default.Face, description = "Route B"),
    RouteC to NavBarItem(icon = Icons.Default.Camera, description = "Route C"),
)

@Serializable
data object RouteA: NavKey

@Serializable
data object RouteA1: NavKey

@Serializable
data object RouteB: NavKey

@Serializable
data object RouteB1: NavKey

@Serializable
data object RouteC: NavKey

@Serializable
data object RouteC1: NavKey


data class NavBarItem(val icon: ImageVector, val description: String)