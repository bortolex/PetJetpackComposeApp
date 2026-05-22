package com.example.petjetpackcomposeapp

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.petjetpackcomposeapp.counterFeature.CounterViewModel
import com.example.petjetpackcomposeapp.ui.TestTags
import com.example.petjetpackcomposeapp.ui.TestTags.CounterText
import com.example.petjetpackcomposeapp.ui.TestTags.IncrementButton
import com.example.petjetpackcomposeapp.ui.TestTags.ProgressBar
import com.example.petjetpackcomposeapp.ui.screens.counter.CounterContent
import io.mockk.called
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Test

class CounterContentTest : ComposeTest() {

    @RelaxedMockK // будуть згенеровані несправжні мокові лямбди
    private lateinit var onIncrement: () -> Unit

    @RelaxedMockK
    private lateinit var onSettings: () -> Unit

    @Test
    fun counterContent_withCounterValue_displaysItAsText() = runComposeTest {
        setupCounterContent(counterValue = 10)

        onNodeWithTag(CounterText).assertTextEquals("10")
    }

    @Test
    fun counterContent_withoutIncrementingStatus_doesNotShowProgressAndEnablesButton() = runComposeTest {
        setupCounterContent(isIncrementInProgress = false)

        onNodeWithTag(IncrementButton).assertIsEnabled()
        onNodeWithTag(ProgressBar).assertDoesNotExist()
    }

    @Test
    fun counterContent_withIncrementingStatus_showsProgressAndDisablesButton() = runComposeTest {
        setupCounterContent(isIncrementInProgress = true)

        onNodeWithTag(IncrementButton).assertIsNotEnabled()
        onNodeWithTag(ProgressBar).assertExists()
    }

    @Test
    fun clickOnIncrementButton_executesIncrementAction() = runComposeTest {
        setupCounterContent()

        onNodeWithTag(IncrementButton).performClick()

        verify(exactly = 1) {
            onIncrement()
        }
    }

    @Test
    fun clickOnDisabledIncrementButton_doesNothing() = runComposeTest {
        setupCounterContent(isIncrementInProgress = true)

        onNodeWithTag(IncrementButton).performClick()

        verify {
            onIncrement wasNot called
        }
    }

    @Test
    fun clickOnSettingsButton_executesSettingsAction() = runComposeTest {
        setupCounterContent()

        onNodeWithTag(TestTags.SettingsButton).performClick()

        verify(exactly = 1) {
            onSettings()
        }
    }

    private fun ComposeContentTestRule.setupCounterContent(
        counterValue: Int = 0,
        isIncrementInProgress: Boolean = false,
    ) {
        setContent {
            CounterContent(
                screenState = CounterViewModel.ScreenState(counterValue, isIncrementInProgress),
                onIncrement = onIncrement,
                onLaunchSettings = onSettings,
            )
        }
    }

}