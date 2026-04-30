package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Example00Default(){
    ConstraintLayout{

    }
        Square()

}

@Composable
fun Square(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    size: Dp = 100.dp
){
    CustomRectangle(modifier, size, size, color)
}

@Composable
fun CustomRectangle(
    modifier: Modifier = Modifier,
    width: Dp = 100.dp,
    height: Dp = 100.dp,
    color: Color = Color.Black
) {
    Box(
        modifier.then(
            Modifier
                .size(width, height)
                .background(color)
        )
    )
}