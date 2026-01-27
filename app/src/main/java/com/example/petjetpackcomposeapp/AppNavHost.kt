package com.example.petjetpackcomposeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petjetpackcomposeapp.screens.HomeScreen

@Composable
fun CustomNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
//        composable("profile") { ProfileScreen(navController) }
//        composable("settings") { SettingsScreen(navController) }

//        composable("notifications") { NotificationsScreen(navController) }
//        composable("details") { DetailsScreen(navController) }
    }
}


