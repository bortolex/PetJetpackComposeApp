package com.example.petjetpackcomposeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petjetpackcomposeapp.screens.TopAppBar
import com.example.petjetpackcomposeapp.screens.DetailsScreen
import com.example.petjetpackcomposeapp.screens.NewHomeScreen
import com.example.petjetpackcomposeapp.screens.getRelevantAppBarIcon
import com.example.petjetpackcomposeapp.states.AppBarState

@Composable
fun AppNavGraph() {
        val navController =
                rememberNavController() // it's object which manages navigation between composable screens
        val backStackEntry by navController.currentBackStackEntryAsState()
        val destinationId = backStackEntry?.destination?.route
        val canNavigateBack = navController.previousBackStackEntry != null

        val appBarState = remember(destinationId, canNavigateBack) {
                AppBarState(
                        destinationId = destinationId,
                        icon = getRelevantAppBarIcon(destinationId),
                        onIconClick = if (canNavigateBack) ({ navController.popBackStack() }) else null
                )
        }

        Scaffold(topBar = { TopAppBar(appBarState) }) { innerPadding ->
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