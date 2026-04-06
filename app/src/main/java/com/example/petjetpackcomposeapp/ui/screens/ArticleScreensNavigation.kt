package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "articles"
    ) {

        composable("articles") {
            ArticlesScreen(
                onItemClick = { article ->
                    navController.navigate("details/${article.title}")
                }
            )
        }

        composable(
            route = "details/{articleId}",
            arguments = listOf(
                navArgument("articleId") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val articleId = backStackEntry.arguments?.getString("articleId")

            ArticleDetailsScreen(articleId = articleId)
        }
    }
}