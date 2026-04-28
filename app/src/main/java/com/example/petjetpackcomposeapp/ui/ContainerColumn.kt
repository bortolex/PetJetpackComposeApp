package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * second param of func - ColumnScope
 * it helps us (in this lambda) use certain modifiers which we could use specifically in Columns
 */
@Composable
fun ContainerColumn(name: String, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), shape = RectangleShape){
        Column() {
            Text(name, fontSize = 23.sp)
            content()
        }
    }
}