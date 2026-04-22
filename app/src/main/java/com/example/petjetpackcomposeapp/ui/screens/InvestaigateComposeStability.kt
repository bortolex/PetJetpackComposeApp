package com.example.petjetpackcomposeapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petjetpackcomposeapp.R
import java.util.UUID

/**
 * Code below will help to understand how does it work in compose:
 * 1- stability
 * 2- recomposition in composable funcs
 * 3- how recomposition could be optimized
 * 4-
 */

@Composable
fun InvestigatedScreen() {
    var label by remember { mutableStateOf(Wrapper("Hello")) }
    var counter by remember { mutableIntStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        LabelText(label)
        CounterText(counter)
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = { counter++ }) {
            Text(
                text = stringResource(R.string.increment), fontSize = 18.sp
            )

        }
        Button(onClick = { label = Wrapper(UUID.randomUUID().toString()) }) {
            Text(text = stringResource(R.string.label), fontSize = 18.sp)
        }
    }
}

@Composable
fun CounterText(counterValue: Int) {
    Text(
        text = counterValue.toString(),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace
    )
}

@Composable
fun LabelText(wrapper: Wrapper) {
    Text(
        text = wrapper.label.toString(),
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold
    )
}

data class Wrapper(val label: Any)