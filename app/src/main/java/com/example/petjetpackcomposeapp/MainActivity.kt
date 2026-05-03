package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.compose_navigation.navigation.NavigationHost
import com.example.compose_navigation.navigation.rememberNavigation
import com.example.petjetpackcomposeapp.counterFeature.CounterRepository
import com.example.petjetpackcomposeapp.ui.CounterScreen
import com.example.petjetpackcomposeapp.ui.screens.AddItemScreen
import com.example.petjetpackcomposeapp.ui.screens.ItemsScreen
import com.example.petjetpackcomposeapp.ui.screens.ProfileScreen
import com.example.petjetpackcomposeapp.ui.screens.SettingsScreen
import com.example.petjetpackcomposeapp.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(dynamicColor = false) {
                CounterScreen()
            }
        }
        CounterRepository()
    }
}

@Composable
fun AppContent() {
    val navigation = rememberNavigation(initialDestination = AppRoute.Tab.Items)
    val tabs = listOf(AppRoute.Tab.Items, AppRoute.Tab.Profile, AppRoute.Tab.Settings)

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = navigation.navigationState.currentDestination == tab,
                        onClick = { navigation.routeManager.restart(tab) },
                        icon = { Icon(tab.icon, contentDescription = stringResource(tab.titleRes)) },
                        label = { Text(stringResource(tab.titleRes)) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavigationHost(
            navigationHolder = navigation,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { destination ->
            when (destination) {
                is AppRoute.Tab.Items -> ItemsScreen(
                    onAddItemClick = { navigation.routeManager.open(AppRoute.AddItem) }
                )
                is AppRoute.Tab.Profile -> ProfileScreen()
                is AppRoute.Tab.Settings -> SettingsScreen()
                is AppRoute.AddItem -> AddItemScreen(
                    onBack = { navigation.routeManager.goBack() }
                )
            }
        }
    }
}
