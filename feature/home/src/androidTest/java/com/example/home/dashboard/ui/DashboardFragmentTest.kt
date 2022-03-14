package com.example.home.dashboard.ui

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.home.R
import com.example.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class DashboardFragmentTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun when_YESIsDisplayed() {
        launchFragmentInHiltContainer<DashboardFragment>()
        val inputText = "denizme"
        onView(withId(R.id.input_user_name)).perform(typeText(inputText))
        closeSoftKeyboard()
        onView(withId(R.id.btn_search)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText(inputText)))
    }
}