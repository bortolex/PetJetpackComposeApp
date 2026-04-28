package com.example.petjetpackcomposeapp.ui.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClassicCheckBox() {
    var isChecked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Checkbox(checked = isChecked, onCheckedChange = { changeChecked ->
            isChecked = changeChecked
        })
    }
}