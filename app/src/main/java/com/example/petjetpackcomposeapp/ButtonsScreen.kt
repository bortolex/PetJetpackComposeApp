package com.example.petjetpackcomposeapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showSystemUi = true)
@Composable
fun SimpleButtonInBox(printedText: String) {
    val context:Context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ) {
        Button(
            onClick = {
                Toast.makeText(context, printedText, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Click Me")
        }

    }
}