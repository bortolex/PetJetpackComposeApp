package com.example.petjetpackcomposeapp.counterFeature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.petjetpackcomposeapp.ui.TestTags

@Composable
fun <T> LoadResultContent(
    loadResult: LoadResult<T>,
    exceptionMessageMapper: ExceptionMessageMapper = ExceptionMessageMapper.DEFAULT,
    onTryAgain: () -> Unit = {},
    content: @Composable (T) -> Unit,
) {
    when (loadResult) {
        LoadResult.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(Modifier.testTag(TestTags.ScreenProgressBar))
            }
        }
        is LoadResult.Error -> {
            val exception = loadResult.exception
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val context = LocalContext.current
                Text(
                    text = exceptionMessageMapper.toUserMessage(context, exception),
                    modifier = Modifier.testTag(TestTags.ErrorText),
                    textAlign = TextAlign.Center,
                )
                Button(
                    onClick = { onTryAgain() },
                    modifier = Modifier.testTag(TestTags.TryAgainButton)
                ) {
                    Text(text = stringResource(R.string.try_again))
                }
            }
        }
        is LoadResult.Success -> content(loadResult.value)
    }
}