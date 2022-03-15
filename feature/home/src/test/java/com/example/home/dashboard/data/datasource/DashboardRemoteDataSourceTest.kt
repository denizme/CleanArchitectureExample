package com.example.home.dashboard.data.datasource

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.datasource.DashboardRemoteDataSource
import com.example.home.dashboard.data.remote.datasource.DashboardRemoteDataSourceImpl
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.data.remote.service.DashboardService
import com.example.home.shared.extension.runBlockingTest
import com.example.home.shared.rule.CoroutinesTestRule
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DashboardRemoteDataSourceTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    private lateinit var service: DashboardService

    private lateinit var dataSource: DashboardRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataSource = DashboardRemoteDataSourceImpl(service)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `data source should return data`() = coroutinesTestRule.runBlockingTest {
        // Given
        coEvery {
            service.getUserRepos("denizme")
        }.coAnswers {
            arrayListOf()
        }

        // When
        val result: DataFetchResult<List<UserRepoResponse>> = dataSource.getUserRepos("denizme")

        // Then
        Truth.assertThat(result).isNotNull()
        Truth.assertThat(result).isInstanceOf(DataFetchResult.Success::class.java)

        coVerify(exactly = 1) { service.getUserRepos("denizme") }
        confirmVerified(service)
    }
}