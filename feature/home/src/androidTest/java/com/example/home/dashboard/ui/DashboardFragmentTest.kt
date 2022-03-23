package com.example.home.dashboard.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.home.R
import com.example.launchFragmentInHiltContainer
import com.example.shared.extension.runBlockingTest
import com.example.shared.rule.CoroutinesTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class DashboardFragmentTest {


    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()


    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun when_YESIsDisplayed() = coroutinesTestRule.runBlockingTest {
        val inputText = "denizme"
        launchFragmentInHiltContainer<DashboardFragment>(){

        }
        onView(withId(R.id.input_user_name)).perform(typeText(inputText))
        closeSoftKeyboard()
        onView(withId(R.id.btn_search)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText(inputText)))
    }
}