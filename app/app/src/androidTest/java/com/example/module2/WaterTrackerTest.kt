package com.example.module2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.module2.ui.theme.MyApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyApplicationTheme {
                WaterTracker()
            }
        }
    }

    private fun drink(times: Int) = repeat(times) {
        composeTestRule.onNodeWithText("+250 мл").performClick()
    }

    @Test
    fun knopkaEstNalivaet250() {
        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("0 мл").assertExists()
        drink(1)
        composeTestRule.onNodeWithText("250 мл").assertExists()
        drink(1)
        composeTestRule.onNodeWithText("500 мл").assertExists()
    }

    @Test
    fun knopkaFinishResetsWater() {
        composeTestRule.onNodeWithText("Завершить день").assertExists()
        drink(2)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }

    @Test
    fun strikS4itaetISbrasivaet() {
        composeTestRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertExists()

        drink(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с 1500 мл и больше: 1").assertExists()

        drink(7)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с 1500 мл и больше: 2").assertExists()

        drink(5)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertExists()
    }
}
