package com.example.petjetpackcomposeapp.ui.navigation

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


data class DataTabItem(val icon: ImageVector, val title: String)

@Composable
fun SimpleNavigation() {
    val items = listOf(
        DataTabItem(Icons.Default.Home, "home"),
        DataTabItem(Icons.Default.Search, "search"),
        DataTabItem(Icons.Default.Settings, "settings")
    )
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        NavigationBar() {
        items.forEach {
            NavigationBarItem(
                selected = true,
                onClick = {},
                label = { Text(it.title) },
                icon = {}
            )
        }

    }
    }) { innerPadding ->
        NavHost(
            navController,
            startDestination = items[0].title,
            modifier = Modifier.padding(innerPadding)
        ) {
            items.forEach { dataTab ->
                composable(route = dataTab.title) {}
            }
        }
    }
}