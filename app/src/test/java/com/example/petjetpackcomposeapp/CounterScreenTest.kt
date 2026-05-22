package com.example.petjetpackcomposeapp

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.petjetpackcomposeapp.counterFeature.CounterViewModel
import com.example.petjetpackcomposeapp.counterFeature.LoadResult
import com.example.petjetpackcomposeapp.counterFeature.updateIfSuccess
import com.example.petjetpackcomposeapp.ui.TestTags.CounterText
import com.example.petjetpackcomposeapp.ui.TestTags.IncrementButton
import com.example.petjetpackcomposeapp.ui.TestTags.ScreenProgressBar
import com.example.petjetpackcomposeapp.ui.TestTags.SettingsButton
import com.example.petjetpackcomposeapp.ui.screens.counter.CounterScreen
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Test

class CounterScreenTest : ComposeTest() {

    @MockK(relaxUnitFun = true)
    private lateinit var viewModel: CounterViewModel

    private lateinit var testViewModelStoreOwner: TestViewModelStoreOwner

    private lateinit var stateFlow: MutableStateFlow<LoadResult<CounterViewModel.ScreenState>>

    @Before
    fun setUp() = runComposeTest {
        stateFlow = MutableStateFlow(
            LoadResult.Success(
                CounterViewModel.ScreenState(
                    counterValue = 0,
                    isIncrementInProgress = false
                )
            )
        )
        every { viewModel.screenStateFlow } returns stateFlow
        testViewModelStoreOwner = TestViewModelStoreOwner(viewModel)
        setContent {
            CompositionLocalProvider(
                LocalViewModelStoreOwner provides testViewModelStoreOwner
            ) {
                CounterScreen()
            }
        }
    }

    @Test
    fun counterScreen_subscribesToScreenState() = runComposeTest {
        // assert initial state
        onNodeWithTag(CounterText).assertTextEquals("0")
        // assert updating
        stateFlow.updateIfSuccess { it.copy(counterValue = 10) }
        onNodeWithTag(CounterText).assertTextEquals("10")
        // assert the usage of LoadResultContent
        stateFlow.value = LoadResult.Loading
        onNodeWithTag(CounterText).assertDoesNotExist()
        onNodeWithTag(ScreenProgressBar).assertExists()
    }

    @Test
    fun counterScreen_delegatesIncrementCallToViewModel() = runComposeTest {
        onNodeWithTag(IncrementButton).performClick()

        verify(exactly = 1) {
            viewModel.increment()
        }
    }

    @Test
    fun counterScreen_delegatesSettingsCallToViewModel() = runComposeTest {
        onNodeWithTag(SettingsButton).performClick()

        verify(exactly = 1) {
            viewModel.launchSettings()
        }
    }

}