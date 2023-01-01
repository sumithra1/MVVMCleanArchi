package com.example.mvvmcleanarchidemo1.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmcleanarchidemo1.data.api.FakeNetworkService
import com.example.data.repository.GamesRepoImpl
import com.example.data.repository.datasourceimpl.RemoteDataSourceImpl
import com.example.domain.repository.GamesRepo
import com.example.domain.usecase.GetGamesUseCase
import com.example.mvvmcleanarchidemo1.data.repository.FakeDataGenerator
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
    private lateinit var fakeNetworkService: FakeNetworkService
    private lateinit var accountRepository: GamesRepo


    @Before
    fun setup() {
        fakeNetworkService = FakeNetworkService(FakeDataGenerator.amiibo)
        accountRepository = GamesRepoImpl(RemoteDataSourceImpl(fakeNetworkService))
        fakeUseCase = GetGamesUseCase(accountRepository)
        gamesViewModel = GameViewModel(fakeUseCase)
    }

    @Test
    fun getGamesDataNotNull() {
        assertThat(gamesViewModel.getGamesData()).isNotNull()
    }
}