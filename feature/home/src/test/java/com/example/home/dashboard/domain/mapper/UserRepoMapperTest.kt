package com.example.home.dashboard.domain.mapper

import com.example.home.dashboard.data.model.getUserRepoResponse
import com.example.home.shared.extension.runBlockingTest
import com.example.home.shared.rule.CoroutinesTestRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserRepoMapperTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var mapper: UserRepoMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mapper = UserRepoMapper()
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `mapper should map domain item to view item type properly`() = coroutinesTestRule.runBlockingTest {
            // Given
            val domainItem = arrayListOf(getUserRepoResponse())

            // When
            val viewItem = mapper.invoke(domainItem)

            // Then
            Truth.assertThat(viewItem).isNotNull()
            Truth.assertThat(viewItem[0].id).isEqualTo(1)
            Truth.assertThat(viewItem[0].name).isEqualTo("test")
        }
}