package com.example.petjetpackcomposeapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import com.example.petjetpackcomposeapp.ui.navigation.Routes.DETAILS_HOME
import com.example.petjetpackcomposeapp.ui.navigation.Routes.HOME
import com.example.petjetpackcomposeapp.ui.navigation.Routes.PUSH
import com.example.petjetpackcomposeapp.ui.navigation.Routes.SEARCH
import com.example.petjetpackcomposeapp.ui.navigation.Routes.SETTINGS
import com.example.petjetpackcomposeapp.ui.navigation.screens.DetailsScreen
import com.example.petjetpackcomposeapp.ui.navigation.screens.HomeScreen

data class DataTabItem(val icon: ImageVector, val title: String)

@Composable
fun SimpleNavigation() {
    val items = listOf(
        DataTabItem(Icons.Default.Home, "home"),
        DataTabItem(Icons.Default.Search, "search"),
        DataTabItem(Icons.Default.Settings, "settings")
    )
    val routes = listOf(Routes.HOME, Routes.SEARCH, Routes.SETTINGS)
    val navController = rememberNavController() // rememberNavController makes it with survival of config changes
    Scaffold(bottomBar = {
        NavigationBar() {
        items.forEachIndexed { index, it ->
            NavigationBarItem(
                selected = true,
                onClick = { navController.navigate(routes[index]) },
                label = { Text(it.title) },
                icon = {}
            )
        }

    }
    }) { innerPadding ->
        NavHost(
            navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(HOME) { backStackEntry ->
                HomeScreen(navController) }
            composable(SEARCH) {}
            composable(PUSH) {}
            composable(SETTINGS) {}
            composable(DETAILS_HOME) {DetailsScreen()}
        }
    }
}

