package com.example.petjetpackcomposeapp.draft.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen() {
    Column(Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )
        Spacer(modifier = Modifier.size(25.dp))
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )
        Spacer(modifier = Modifier.size(25.dp))
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )
        Spacer(modifier = Modifier.size(25.dp))
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )
        Spacer(modifier = Modifier.size(25.dp))
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )
        Spacer(modifier = Modifier.size(25.dp))
        Icon(
            imageVector = Icons.Default.Face, contentDescription = null
        )

    }
}