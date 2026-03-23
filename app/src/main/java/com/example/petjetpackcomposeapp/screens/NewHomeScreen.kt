package com.example.petjetpackcomposeapp.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petjetpackcomposeapp.R
import com.example.petjetpackcomposeapp.states.AppBarState
import com.example.petjetpackcomposeapp.ui.theme.TopAppBarSurfaceColor
import com.example.petjetpackcomposeapp.viewModels.MainViewModelFactory
import com.example.petjetpackcomposeapp.viewModels.newOne.NewHomeViewModel

@Composable
fun NewHomeScreen(clickNavigation: () -> Unit) {
//    val owner = LocalViewModelStoreOwner.current!!
    val activity = LocalContext.current as ComponentActivity
    val viewModel: NewHomeViewModel = viewModel(
        factory = MainViewModelFactory(
            owner = activity
        )
    )

    val uiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    println("check received uiState: $uiState")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(modifier = Modifier
            .padding(/*top = 25.dp,*/ bottom = 24.dp)
            .align(Alignment.CenterHorizontally), onClick = {
            clickNavigation.invoke()
        }) {
            Text("go to DetailsScreen")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(appBarState: AppBarState) {
    TopAppBar(modifier = Modifier.background( //it's internal background.
        // So we need to make upper background as transparent
        color = TopAppBarSurfaceColor, shape = RoundedCornerShape(36.dp)
    ),
        title = { //title in TopAppBar is composable function. So it's not required to have a text.
            // It could be even image or something else
            Text(text = stringResource(R.string.title_top_app_bar))
        },
        navigationIcon = {
            if (appBarState.onIconClick != null) {
                Button(onClick = { appBarState.onIconClick.invoke() }) {
                    Icon(
                        imageVector = appBarState.icon, contentDescription = null
                    )
                }
            } else {
                Icon(
                    imageVector = appBarState.icon, contentDescription = null
                )
            }
        },
        // Make TopAppBar container transparent so Surface shows
        // (we couldn't apply our own background color and shape without this piece of code)
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )

    )
}

fun getRelevantAppBarIcon(destinationId: String?): ImageVector =
    when (destinationId) {
        "home" -> Icons.Default.Home
        null, "" -> Icons.Default.Face
        else -> Icons.AutoMirrored.Filled.ArrowBack
    }
