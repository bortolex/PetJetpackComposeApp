package com.example.petjetpackcomposeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petjetpackcomposeapp.R
import com.example.petjetpackcomposeapp.ui.theme.TopAppBarSurfaceColor

@Composable
fun NewHomeScreen(clickNavigation: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(modifier = Modifier.padding(top = 25.dp), onClick = {
            clickNavigation.invoke()
        }) { }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopAppBar(destinationId: String?) {
    TopAppBar(modifier = Modifier.background(
        color = TopAppBarSurfaceColor, shape = RoundedCornerShape(36.dp)
    ), title = { //title in TopAppBar is composable function. So it's not required to have a text.
        // It could be even image or something else
        Text(text = stringResource(R.string.title_top_app_bar)) },
        navigationIcon = {
        Icon(
            imageVector = getRelevantAppBarIcon(destinationId = destinationId), contentDescription = null
        )
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
