package com.example.petjetpackcomposeapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.petjetpackcomposeapp.ui.navigation.screens.DetailsScreen
import com.example.petjetpackcomposeapp.ui.navigation.screens.HomeScreen

data class DataTabItem(val icon: ImageVector, val title: String, val route: NavKey)

@Composable
fun SimpleNavigation() {
    val tabs = listOf(
        DataTabItem(Icons.Default.Home, "home", Home),
        DataTabItem(Icons.Default.Search, "search", Search),
        DataTabItem(Icons.Default.Settings, "settings", Settings),
    )
    val backStack = remember { mutableStateListOf<NavKey>(Home) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = backStack.last() == tab.route,
                        onClick = {
                            backStack.clear()
                            backStack.add(tab.route)
                        },
                        label = { Text(tab.title) },
                        icon = { Icon(tab.icon, contentDescription = tab.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
            modifier = Modifier.padding(innerPadding),
        ) { key ->
            NavEntry(key) {
                when (key) {
                    Home -> HomeScreen(onItemClick = { backStack.add(DetailsHome) })
                    Search -> Text("Search")
                    Push -> Text("Push")
                    Settings -> Text("Settings")
                    DetailsHome -> DetailsScreen()
                }
            }
        }
    }
}
