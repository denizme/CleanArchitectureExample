package com.example.home.dashboard.data.repository

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.datasource.DashboardRemoteDataSource
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.domain.repository.DashboardRepository
import com.example.home.shared.extension.runBlockingTest
import com.example.home.shared.rule.CoroutinesTestRule
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DashboardRepositoryImplTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    private lateinit var dashboardRemoteDataSource: DashboardRemoteDataSource

    @MockK
    private lateinit var userRepoResponse: List<UserRepoResponse>

    lateinit var dashboardRepository: DashboardRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dashboardRepository = DashboardRepositoryImpl(dashboardRemoteDataSource)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    private val userName = "park"

    @Test
    fun `repository should return MovieResponse`() = coroutinesTestRule.runBlockingTest {
        //Given
        coEvery {
            dashboardRemoteDataSource.getUserRepos(userName)
        } coAnswers {
            DataFetchResult.success(userRepoResponse)
        }

        every {
            userRepoResponse[0].id
        } returns 1

        //when
        val result = dashboardRepository.getUserRepos(userName)

        // Then
        Truth.assertThat(result).isNotNull()
        Truth.assertThat(result).isInstanceOf(DataFetchResult.Success::class.java)
        Truth.assertThat((result as DataFetchResult.Success).data[0].id).isEqualTo(1)

        coVerify(exactly = 1) { dashboardRemoteDataSource.getUserRepos(userName) }
        confirmVerified(dashboardRemoteDataSource)
    }
}