package com.example.home.dashboard.domain.usecase

import com.example.core.data.models.DataFetchResult
import com.example.home.dashboard.data.remote.model.UserRepoResponse
import com.example.home.dashboard.domain.mapper.UserRepoMapper
import com.example.home.dashboard.domain.model.UserRepo
import com.example.home.dashboard.domain.repository.DashboardRepository
import com.example.home.shared.extension.runBlockingTest
import com.example.home.shared.rule.CoroutinesTestRule
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserRepoUseCaseTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    private lateinit var repository: DashboardRepository

    @MockK
    private lateinit var mapper: UserRepoMapper

    @RelaxedMockK
    private lateinit var movie: List<UserRepo>

    private lateinit var useCase: UserRepoUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = UserRepoUseCase(repository, mapper)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `use case should return data properly`() = coroutinesTestRule.runBlockingTest {
        // Given
        coEvery {
            repository.getUserRepos("test")
        } coAnswers {
            DataFetchResult.success(arrayListOf())
        }

        coEvery {
            mapper.invoke(any())
        }.coAnswers {
            movie
        }

        // Then
        val result = useCase.execute(UserRepoParams("test"))

        // Then
        Truth.assertThat(result).isNotNull()
        Truth.assertThat(result).isInstanceOf(DataFetchResult.Success::class.java)

        coVerify(exactly = 1) { repository.getUserRepos("test") }
        coVerify(exactly = 1) { mapper.invoke(any()) }
        confirmVerified(repository)
        confirmVerified(mapper)
    }
}