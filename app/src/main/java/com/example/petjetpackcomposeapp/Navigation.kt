package com.example.petjetpackcomposeapp

import android.widget.Button
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petjetpackcomposeapp.screens.DetailsScreen
import com.example.petjetpackcomposeapp.screens.NewHomeScreen

@Composable
fun AppNavGraph() {
        val navController = rememberNavController() // it's object which manages navigation between composable screens

        NavHost(navController = navController, startDestination = "home"){
                composable("home") {
                        NewHomeScreen{
                                navController.navigate("details")
                        }
                }

                composable("details") {
                        DetailsScreen()
                }
        }

//        NavHost (
//                navController = navController,
//                startDestination =
//        )
}