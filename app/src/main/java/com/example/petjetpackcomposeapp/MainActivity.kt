package com.example.petjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.petjetpackcomposeapp.ui.OutlinedTextFieldScreen
import com.example.petjetpackcomposeapp.ui.SimpleButtonInBox


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            OutlinedTextFieldScreen()
//            SimpleButtonInBox("test TEXT")
//            HelloWorld()
        }
    }


    @Preview (showBackground = true)
    @Composable
    fun HelloWorld() {
        Text(
            "Hello World",
            fontSize = 35.sp,
            color = Color.Green,
            modifier = Modifier.background(Color.Cyan)
        )
    }
}

