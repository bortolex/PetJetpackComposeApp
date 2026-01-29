package com.example.petjetpackcomposeapp

import android.widget.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petjetpackcomposeapp.screens.BaseTopAppBar
import com.example.petjetpackcomposeapp.screens.DetailsScreen
import com.example.petjetpackcomposeapp.screens.NewHomeScreen

@Composable
fun AppNavGraph() {
        val navController =
                rememberNavController() // it's object which manages navigation between composable screens

        Scaffold(topBar = { BaseTopAppBar() }) { innerPadding ->
                NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                ) {
                        composable("home") {
                                NewHomeScreen(
                                        clickNavigation = { navController.navigate("details") }
                                )
                        }
                        composable("details") {
                                DetailsScreen()
                        }
                }
        }
}

//        NavHost(navController = navController, startDestination = "home") {
//                composable("home") {
//                        NewHomeScreen {
//                                navController.navigate("details")
//                        }
//                }
//
//                composable("details") {
//                        DetailsScreen()
//                }
//        }

//        NavHost (
//                navController = navController,
//                startDestination =
//        )