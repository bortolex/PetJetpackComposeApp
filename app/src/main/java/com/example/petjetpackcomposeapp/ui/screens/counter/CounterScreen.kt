package com.example.petjetpackcomposeapp.ui.screens.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.petjetpackcomposeapp.R
import com.example.petjetpackcomposeapp.counterFeature.CounterViewModel
import com.example.petjetpackcomposeapp.counterFeature.LoadResultContent
import com.example.petjetpackcomposeapp.ui.TestTags

@Composable
fun CounterScreen() {
    val viewModel = hiltViewModel<CounterViewModel>()
    val loadResult by viewModel.screenStateFlow.collectAsState()
    LoadResultContent(
        loadResult = loadResult,
    ) { screenState ->
        CounterContent(
            screenState = screenState,
            onIncrement = viewModel::increment,
            onLaunchSettings = viewModel::launchSettings,
        )
    }
}

@Composable
fun CounterContent(
    screenState: CounterViewModel.ScreenState,
    onIncrement: () -> Unit,
    onLaunchSettings: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = screenState.counterValue.toString(),
            modifier = Modifier.testTag(TestTags.CounterText),
            fontSize = 32.sp,
        )
        Spacer(Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = onIncrement,
                modifier = Modifier.testTag(TestTags.IncrementButton),
                enabled = !screenState.isIncrementInProgress
            ) {
                Text(stringResource(R.string.increment))
            }
            if (screenState.isIncrementInProgress) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp)
                        .testTag(TestTags.ProgressBar),
                )
            }
        }
        Button(
            onClick = onLaunchSettings,
            modifier = Modifier.testTag(TestTags.SettingsButton),
        ) {
            Text(stringResource(R.string.settings))
        }
    }
}