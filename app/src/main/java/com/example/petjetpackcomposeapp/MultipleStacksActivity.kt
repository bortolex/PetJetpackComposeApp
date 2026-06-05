package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import com.example.compose_navigation.navigation.rememberNavigation
import com.example.petjetpackcomposeapp.ui.navigation.SimpleNavigation
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.Navigator
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.RouteA
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.RouteA1
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.RouteB1
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.RouteC1
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.TOP_LEVEL_ROUTES
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.featureASection
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.featureBSection
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.featureCSection
import com.example.petjetpackcomposeapp.ui.navigation.multiplestacks.rememberNavigationState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultipleStacksActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationState =
                rememberNavigationState(startRoute = RouteA, topLevelRoutes = TOP_LEVEL_ROUTES.keys)
            val navigator = remember { Navigator(navigationState) }
            val entryProvider = entryProvider {
                featureASection(onSubRouteClick = { navigator.navigate(RouteA1) })
                featureBSection(onSubRouteClick = { navigator.navigate(RouteB1) })
                featureCSection(onSubRouteClick = { navigator.navigate(RouteC1) })
            }

        }
    }
}
