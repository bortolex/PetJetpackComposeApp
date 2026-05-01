package com.example.petjetpackcomposeapp

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.petjetpackcomposeapp.ui.CounterScreen
import com.example.petjetpackcomposeapp.ui.CounterTestTags
import com.example.petjetpackcomposeapp.ui.CounterTestTags.COUNTER_TEXT
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
        onNodeWithTag(CounterTestTags.INCREMENT_BUTTON).performClick()

        //assert
        onNodeWithTag(COUNTER_TEXT).assertTextEquals("1")
    }

    @Test
    fun initialCounter_containsZeroValue(): Unit = with(composeTestRule) {
// arrange
        setContent {
            CounterScreen()
        }

        //we don't have an act because it's initial state
        onNodeWithTag(COUNTER_TEXT).assertTextEquals("0")
        /*.performClick()*/

//        assert
//        onNodeWithTag(COUNTER_TEXT).assertTextEquals("1")
    }
}