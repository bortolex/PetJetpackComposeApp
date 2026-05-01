package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview()
@Composable
fun Example00Default() {
    ConstraintLayout {
        Square(color = Color.Magenta, size = 300.dp)
        Square()
    }
}

/**
 * set center through ConstraintLayout
 */
@Preview()
@Composable
fun Example01Default() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        Square(color = Color.Magenta, size = 300.dp, modifier = Modifier.constrainAs(createRef()) {
            centerVerticallyTo(parent)
        })
        Square(modifier = Modifier.constrainAs(createRef()){
            centerHorizontallyTo(parent)
        })
    }
}

@Preview
@Composable
fun Example02Default() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val yellowSquare = Modifier.constrainAs(createRef())
        Square(size = 75.dp, color = Color.Magenta, modifier = Modifier.constrainAs(createRef()) {
            bottom.linkTo(parent.bottom)
            centerHorizontallyTo(parent)
        })

        Square(size = 250.dp, color = Color.Cyan, modifier = Modifier.constrainAs(createRef()) {
            centerTo(parent)
//            top.linkTo(yellowSquare)
        })

        Square(size = 25.dp, color = Color.Yellow)

    }
}

@Preview
@Composable
fun Example03Default() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val yellowSquare = Modifier.constrainAs(createRef())
        Square(size = 75.dp, color = Color.Magenta, modifier = Modifier.constrainAs(createRef()) {
            bottom.linkTo(parent.bottom)
            centerHorizontallyTo(parent)
        })

        Square(size = 250.dp, color = Color.Cyan, modifier = Modifier.constrainAs(createRef()) {
            centerTo(parent)
//            top.linkTo(yellowSquare)
        })

        Square(size = 25.dp, color = Color.Yellow)

    }
}

@Preview(showSystemUi = true, locale = "ar")
@Composable
fun Example04Default() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val yellowSquare = Modifier.constrainAs(createRef())
        Square(size = 75.dp, color = Color.Magenta, modifier = Modifier.constrainAs(createRef()) {
            bottom.linkTo(parent.bottom)
            absoluteLeft.linkTo(parent.absoluteLeft)
        })

        Square(size = 250.dp, color = Color.Cyan, modifier = Modifier.constrainAs(createRef()) {
            centerTo(parent)
//            top.linkTo(yellowSquare)
        })

        Square(size = 25.dp, color = Color.Yellow)
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExampleMarginDefault() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val yellowSquare = Modifier.constrainAs(createRef())
        Square(size = 75.dp, color = Color.Magenta, modifier = Modifier.constrainAs(createRef()) {
            bottom.linkTo(parent.bottom/*, margin = 16.dp*/)
            absoluteLeft.linkTo(parent.absoluteLeft, margin = 32.dp)
        })

        Square(size = 250.dp, color = Color.Cyan, modifier = Modifier.constrainAs(createRef()) {
            centerTo(parent)
//            top.linkTo(yellowSquare)
        })

        Square(size = 25.dp, color = Color.Yellow)
    }
}

@Composable
fun ExampleLinkElementsDefault(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        Square(size = 40.dp, color = Color.Red, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 60.dp, color = Color.Blue, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 80.dp, color = Color.Green, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 100.dp, color = Color.Yellow, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 50.dp, color = Color.Cyan, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 120.dp, color = Color.Magenta, modifier = Modifier.constrainAs(createRef()) {})
        Square(size = 70.dp, color = Color(0xFFFF9800), modifier = Modifier.constrainAs(createRef()) {})
    }
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