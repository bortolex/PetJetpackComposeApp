package com.example.petjetpackcomposeapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.sp
import com.example.petjetpackcomposeapp.ui.CounterTestTags.COUNTER_TEXT
import kotlin.concurrent.timer
import kotlin.random.Random

@Composable
fun CounterScreen() {
    var count by rememberSaveable { mutableIntStateOf(0) }
//    SimpleSideEffectExample(counter = count)
//    LaunchedEffectExampleWithStaticKey(counter = count)
//    LaunchedEffectExampleWithDynamicKey(count)
    DisposableEffectExample()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$count", fontSize = 48.sp,
            modifier = Modifier.testTag(COUNTER_TEXT))
        Button(onClick = { count++ }, Modifier.semantics {
            this.testTag = CounterTestTags.INCREMENT_BUTTON
        }) {
            Text("Increment")
        }
    }
}

@Composable
fun SimpleSideEffectExample(counter: Int) = SideEffect {
    println("SideEffect, counter = $counter")
}

@Composable
fun LaunchedEffectExampleWithStaticKey(counter: Int) = LaunchedEffect(0) {
    println("LaunchedEffect, counter = $counter")
}

@Composable
fun LaunchedEffectExampleWithDynamicKey(counter: Int) = LaunchedEffect(counter) {
    println("LaunchedEffect, counter = $counter")
}

@Composable
fun DisposableEffectExample() = DisposableEffect(0) {
    println("Disposable SideEffect - started")
    val timer = timer(period = 1000L) {
        println("Disposable SideEffect - running ${Random.nextInt(1000)}")
    }

    onDispose {
        timer.cancel()
        println("Disposable SideEffect - cancelled")
    }
}
