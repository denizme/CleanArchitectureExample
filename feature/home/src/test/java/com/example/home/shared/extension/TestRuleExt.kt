package com.example.home.shared.extension

import com.example.home.shared.rule.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest

@ExperimentalCoroutinesApi
fun CoroutinesTestRule.runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) {
    testDispatcher.runBlockingTest(block)
}