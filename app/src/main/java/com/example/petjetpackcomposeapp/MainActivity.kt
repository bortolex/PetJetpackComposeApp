package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.petjetpackcomposeapp.base.AppRoute
import com.example.petjetpackcomposeapp.ui.AppScreen
import com.example.petjetpackcomposeapp.ui.theme.AppTheme

/**
 * The list of all root tabs
 */
val RootTabs: List<AppRoute.Tab> =
    listOf(AppRoute.Tab.Items, AppRoute.Tab.Settings, AppRoute.Tab.Profile)

class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                AppTheme {
                    AppScreen()
                }
            }
        }
}



