package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationHost(
    navigation: Navigation,
    modifier: Modifier = Modifier,
    routeMapper: @Composable (Route) -> Unit)
{

}