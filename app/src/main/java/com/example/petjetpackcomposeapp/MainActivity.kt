package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.petjetpackcomposeapp.ui.screens.SquareLayersScreen
import com.example.petjetpackcomposeapp.ui.screens.UserSearchScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SquareLayersScreen()
        }
    }

    @Preview (showSystemUi = true)
    @Composable
    fun HelloWorld() {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color.Red).fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            
        ) {
            Text(
                "Hello World",
                fontSize = 35.sp,
                color = Color.Green,
                modifier = Modifier.background(Color.Cyan)
            )
            Text("SECOND TEXT")
        }
    }
}

