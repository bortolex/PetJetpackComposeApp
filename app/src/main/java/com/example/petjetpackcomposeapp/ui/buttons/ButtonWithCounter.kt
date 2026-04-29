package com.example.petjetpackcomposeapp.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ButtonAndCounter() {
    var counterClick by remember { mutableStateOf(0) }
    Column() {
        Button(onClick = { counterClick++ }, modifier = Modifier.background(Color.Blue)) {
            Text("Click me", fontSize = 20.sp)
        }
    }
}