package com.example.mvvmcleanarchidemo1.presentation.viewmodels


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.domain.usecase.GamesUsecase
import com.example.gamessupermariofinal.viewmodels.GameViewModel
import com.example.mvvmcleanarchidemo1.data.repository.FakeRepo

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class GamesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var gamesViewModel: GameViewModel


    @Before
    fun setup() {
        val fakeGamesRepository = FakeRepo()
        val getGamesUsecase = GamesUsecase(fakeGamesRepository)
        gamesViewModel = GameViewModel(getGamesUsecase)
    }

    @Test
    fun getGamesDataRepoNotNull() {
    assertThat(gamesViewModel.getGamesData()).isNotNull()
    }


}

