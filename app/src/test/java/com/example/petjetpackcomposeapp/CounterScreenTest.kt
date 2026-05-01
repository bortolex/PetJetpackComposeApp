package com.example.petjetpackcomposeapp

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.petjetpackcomposeapp.ui.CounterScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CounterScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickIncrementBtn_incrementsCounter(): Unit = with(composeTestRule) {
// arrange
        setContent {
            CounterScreen()
        }

        //act

        //assert
    }
}