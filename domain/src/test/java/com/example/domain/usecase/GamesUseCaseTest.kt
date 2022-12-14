package com.example.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.domain.repository.GamesRepo
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GamesUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var gameRepository: GamesRepo
    private lateinit var subject: GetGamesUseCase

    @Before
    fun setup() {
        gameRepository= FakeGamesRepo()
        subject = GetGamesUseCase(gameRepository)
    }

    @Test
    fun gamesUseCaseTest() = runBlocking {
        val res = subject.execute()
        Truth.assertThat(res).isNotNull()
    }
}