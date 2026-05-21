package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elveum.effects.compose.EffectsApp
import com.elveum.effects.compose.getEffect
import com.example.petjetpackcomposeapp.counterFeature.CounterRoute
import com.example.petjetpackcomposeapp.counterFeature.SettingsRoute
import com.example.petjetpackcomposeapp.ui.effects.NavComponentRouter
import com.example.petjetpackcomposeapp.ui.screens.SettingsScreen
import com.example.petjetpackcomposeapp.ui.screens.counter.CounterScreen
import com.example.petjetpackcomposeapp.ui.theme.TestsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectsApp {
                TestsTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        CounterApp(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navComponentRouter = getEffect<NavComponentRouter>()
    SideEffect {
        navComponentRouter.setNavController(navController)
    }
    NavHost(
        startDestination = CounterRoute,
        navController = navController,
        modifier = modifier.fillMaxSize(),
    ) {
        composable<CounterRoute> { CounterScreen() }
        composable<SettingsRoute> { SettingsScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    TestsTheme {
        CounterApp()
    }
}
