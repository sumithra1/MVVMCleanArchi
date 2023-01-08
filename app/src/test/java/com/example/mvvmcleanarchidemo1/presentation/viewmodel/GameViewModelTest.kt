package com.example.mvvmcleanarchidemo1.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.data.repository.GamesRepoImpl
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.example.domain.repository.GamesRepo
import com.example.domain.usecase.GetGamesUseCase
import com.example.mvvmcleanarchidemo1.viewmodels.GameViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var gamesViewModel: GameViewModel
    private lateinit var fakeUseCase: GetGamesUseCase
    private lateinit var fakeNetworkService: GameFakeService
    private lateinit var gameRepository: GamesRepo


    @Before
    fun setup() {
        fakeNetworkService = GameFakeService(FakeDataGenerator.amiibo)
        gameRepository = GamesRepoImpl(RemoteDataSourceImpl(fakeNetworkService))
        fakeUseCase = GetGamesUseCase(gameRepository)
        gamesViewModel = GameViewModel(fakeUseCase)
    }

    @Test
    fun getGamesDataNotNull() {
        assertThat(gamesViewModel.getGamesData()).isNotNull()
    }
}